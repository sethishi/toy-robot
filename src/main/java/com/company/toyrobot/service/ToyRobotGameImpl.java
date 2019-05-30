package com.company.toyrobot.service;

import com.company.toyrobot.domain.Direction;
import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import com.company.toyrobot.domain.Table;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.company.toyrobot.utils.HelperUtils.getEnumFromStr;
import static java.lang.Integer.valueOf;


@Slf4j
@Component
public class ToyRobotGameImpl extends PlayGame {

  @Autowired
  Table squareTable;

  @Override
  public Game start(String command) {

    String[] s = command.split(" ");

    try {
      if (valueOf(s[1]) > squareTable.getX() || valueOf(s[2]) > squareTable.getY()) {
        log.error("invalid position on table ");
        return null;
      }

    } catch (NullPointerException e) {

    }

    RobotPosition robotPosition = new RobotPosition(valueOf(s[1]), valueOf(s[2]), getEnumFromStr(Direction.class, s[3]));
    return new Game(squareTable, robotPosition);

  }

  @Override
  public Game reset() {
    return new Game();

  }
}
