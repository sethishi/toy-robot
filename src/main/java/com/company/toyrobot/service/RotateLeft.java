package com.company.toyrobot.service;

import com.company.toyrobot.domain.Direction;
import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public class RotateLeft extends Rotate implements ToNewPosition {

  @Override
  public RobotPosition getNewPosition(Game game, String command) {
    int currentX;
    int currentY;

    currentX = game.getRobotPosition().getX();
    currentY = game.getRobotPosition().getY();

    Direction enumFromValue = null;
    Optional<Short> currentPosition = getRobotDirection(game);
    if (currentPosition.isPresent()) {
      short newPosition = (short) (currentPosition.get() - 1);
      if (newPosition <= 0) {
        newPosition = 4;
      }
      enumFromValue  = Direction.getEnumFromValue(newPosition);
    }

    return new RobotPosition(currentX, currentY, enumFromValue);

  }

}
