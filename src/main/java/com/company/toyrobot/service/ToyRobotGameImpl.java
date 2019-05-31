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

  final Table squareTable;

  @Autowired
  public ToyRobotGameImpl(Table squareTable) {
    this.squareTable = squareTable;
  }

  @Override
  public Game start(String command) {

    String[] commands = command.split(" ");
    String[] coordinates = commands[1].split(",");

    try {
      if (valueOf(coordinates[0]) > squareTable.getX() || valueOf(coordinates[1]) > squareTable.getY()) {
        log.error("invalid position on table ");
        return null;
      }

    } catch (NullPointerException e) {

    }

    RobotPosition robotPosition = new RobotPosition(valueOf(coordinates[0]), valueOf(coordinates[1]), getEnumFromStr(Direction.class, coordinates[2]));
    return new Game(squareTable, robotPosition);

  }

  @Override
  public Game reset() {
    return new Game();

  }
}
