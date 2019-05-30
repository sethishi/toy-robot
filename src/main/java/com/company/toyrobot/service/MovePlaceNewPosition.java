package com.company.toyrobot.service;

import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MovePlaceNewPosition implements NewPosition {

  @Override
  public RobotPosition getNewPosition(Game game, String command) {
    PlayGame playGame = new ToyRobotGameImpl();
    playGame.reset();
    Game started = playGame.start(command);
    return started.getRobotPosition();

  }
}
