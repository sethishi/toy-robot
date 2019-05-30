package com.company.toyrobot.service;

import com.company.toyrobot.domain.Direction;
import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import com.company.toyrobot.domain.Table;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MoveRightNewPositionTest {

  private static RobotPosition defaultRobotPosition = new RobotPosition(0, 0, Direction.NORTH);
  private static int UNITS = 4;
  private static Table TEST_SQUARE_TABLE = new Table(UNITS, UNITS);
  MoveRightNewPosition moveRightNewPosition = new MoveRightNewPosition();
  private static String COMMAND = "RIGHT";

  private static Game testGame = new Game(TEST_SQUARE_TABLE, defaultRobotPosition);

  @Test
  public void testRightMoveFromNorth() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.NORTH));
    assertThat(moveRightNewPosition.getNewPosition(testGame,COMMAND).getDirection(), is(Direction.EAST));

  }

  @Test
  public void testRightMoveFromEast() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.EAST));
    assertThat(moveRightNewPosition.getNewPosition(testGame,COMMAND).getDirection(), is(Direction.SOUTH));

  }

  @Test
  public void testRightMoveFromWest() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.WEST));
    assertThat(moveRightNewPosition.getNewPosition(testGame,COMMAND).getDirection(), is(Direction.NORTH));

  }

  @Test
  public void testRightMoveFromSouth() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.SOUTH));
    assertThat(moveRightNewPosition.getNewPosition(testGame,COMMAND).getDirection(), is(Direction.WEST));

  }

  @Test(expected = NullPointerException.class)
  public void testNullDirection() {
    testGame.setRobotPosition(new RobotPosition(1, 2, null));
    assertNull(moveRightNewPosition.getNewPosition(testGame,COMMAND).getDirection());

  }


}