package com.company.toyrobot.service;

import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;

public class MoveReportToNewPosition implements ToNewPosition {

  @Override
  public RobotPosition getNewPosition(Game game, String command) {

    String output = "Output: "+game.getRobotPosition().getX()+ ","+game.getRobotPosition().getY()+","+
        game.getRobotPosition().getDirection().toString();
    System.out.println("\t "+output);
    return game.getRobotPosition();
  }
}
