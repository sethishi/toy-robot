package com.company.toyrobot.service;

import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import com.company.toyrobot.domain.Table;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PlaceToNewPosition implements ToNewPosition {

  @Autowired
  private Table squareTable;

  @Override
  public RobotPosition getNewPosition(Game game, String command) {
    PlayGame playGame = new ToyRobotGameImpl(squareTable);
    playGame.reset();
    Game started = playGame.start(command);
    return started.getRobotPosition();

  }
}
