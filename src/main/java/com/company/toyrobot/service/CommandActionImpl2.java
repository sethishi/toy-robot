package com.company.toyrobot.service;

import com.company.toyrobot.domain.Command;
import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;

import static org.apache.commons.lang3.EnumUtils.isValidEnum;

public class CommandActionImpl2  {
//
//  private Game game;
//
//  MoveRightNewPosition moveRightNewPosition;
//
//  private String command;
//
//  public CommandActionImpl2(Game game, String command) {
//    this.game = game;
//    this.command = command;
//  }
//
//  public RobotPosition performAction() {
//
//    String[] s = command.split(" ");
//    System.out.println(s[0]);
//    if (isValidEnum(Command.class,s[0] )) {
//
//      switch (command.split(" ")[0]) {
//        case "MOVE":
//          MoveNewPostion moveNewPostion = new MoveNewPostion(game);
//          return moveNewPostion.getNewPosition();
//
//        case "RIGHT":
//          MoveRightNewPosition moveRightNewPosition = new MoveRightNewPosition(this.game);
//          return moveRightNewPosition.getNewPosition();
//
//        case "LEFT":
//          MoveLeftNewPosition moveLeftNewPosition = new MoveLeftNewPosition(this.game);
//          return moveLeftNewPosition.getNewPosition();
//        case "PLACE":
//          System.out.println("to be implemented");
//          break;
//
//        case "REPORT":
//          System.out.println("to be implemented");
//          break;
//      }
//    }
//    System.out.println("invalid command " + this.command);
//    return game.getRobotPosition();
//
//  }

}
