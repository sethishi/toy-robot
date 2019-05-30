package com.company.toyrobot.service;

import com.company.toyrobot.domain.Direction;
import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
public class MoveRightNewPosition implements NewPosition {
  private Direction currentDirection;
  private int currentX;
  private int currentY;

  private Game game;

//  public MoveRightNewPosition(Game game) {
//    this.game = game;
//  }

  @Override
  public RobotPosition getNewPosition(Game game, String command) {

    try {

      currentX = game.getRobotPosition().getX();
      currentY = game.getRobotPosition().getY();
      currentDirection = game.getRobotPosition().getDirection();

      switch (currentDirection) {
        case NORTH:
          return new RobotPosition(currentX, currentY, Direction.EAST);
        case EAST:
          return new RobotPosition(currentX, currentY, Direction.SOUTH);
        case WEST:
          return new RobotPosition(currentX, currentY, Direction.NORTH);
        case SOUTH:
          return new RobotPosition(currentX, currentY, Direction.WEST);
      }
      return game.getRobotPosition();
    } catch (NullPointerException e) {
      log.error(e.getLocalizedMessage());
    }
    return null;
  }


}
