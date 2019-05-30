package com.company.toyrobot.service;

import com.company.toyrobot.domain.Direction;
import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MoveLeftNewPosition implements NewPosition {

  private Direction currentDirection;
  private int currentX;
  private int currentY;


  @Override
  public RobotPosition getNewPosition(Game game, String command) {

    currentX = game.getRobotPosition().getX();
    currentY = game.getRobotPosition().getY();
    currentDirection = game.getRobotPosition().getDirection();

    switch (currentDirection) {
      case NORTH:
        return new RobotPosition(currentX, currentY, Direction.WEST);
      case EAST:
        return new RobotPosition(currentX, currentY, Direction.NORTH);
      case WEST:
        return new RobotPosition(currentX, currentY, Direction.SOUTH);
      case SOUTH:
        return new RobotPosition(currentX, currentY, Direction.EAST);
    }
    return game.getRobotPosition();
  }


}
