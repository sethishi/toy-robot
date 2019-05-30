package com.company.toyrobot.service;

import com.company.toyrobot.domain.Direction;
import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MoveNewPosition implements NewPosition {

  private int currentX;
  private int currentY;

  @Override
  public RobotPosition getNewPosition(Game game, String command) {

    currentX = game.getRobotPosition().getX();
    currentY = game.getRobotPosition().getY();
    Direction direction = game.getRobotPosition().getDirection();


    switch (direction) {
      case NORTH:
        if (game.getTable().getY() - (currentY + 1) >= 0) {
          return new RobotPosition(currentX, currentY + 1, direction);
        } else {
          return game.getRobotPosition();
        }
      case EAST:
        if (game.getTable().getX() - (currentX + 1) >= 0) {
          return new RobotPosition(currentX + 1, currentY, direction);
        } else {
          return game.getRobotPosition();
        }
      case WEST:
        if ((currentX - 1) >= 0) {
          return new RobotPosition(currentX - 1, currentY, direction);
        } else {
          return game.getRobotPosition();
        }
      case SOUTH:
        if ((currentY - 1) >= 0) {
          return new RobotPosition(currentX, currentY - 1, direction);
        } else {
          return game.getRobotPosition();
        }

    }
    return game.getRobotPosition();
  }
}
