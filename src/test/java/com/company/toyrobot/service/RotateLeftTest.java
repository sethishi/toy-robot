package com.company.toyrobot.service;

import com.company.toyrobot.domain.Direction;
import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import com.company.toyrobot.domain.Table;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class RotateLeftTest {

  private static RobotPosition defaultRobotPosition = new RobotPosition(0, 0, Direction.NORTH);
  private static int UNITS = 4;
  private static Table TEST_SQUARE_TABLE = new Table(UNITS, UNITS);
  private static String COMMAND = "LEFT";

  private static Game testGame = new Game(TEST_SQUARE_TABLE, defaultRobotPosition);
  RotateLeft rotateLeft = new RotateLeft();

  @Test
  public void testLeftMoveFromNorth() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.NORTH));
    assertThat(rotateLeft.getNewPosition(testGame,COMMAND).getDirection(), is(Direction.WEST));

  }

  @Test
  public void testLeftMoveFromEast() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.EAST));
    assertThat(rotateLeft.getNewPosition(testGame,COMMAND).getDirection(), is(Direction.NORTH));

  }

  @Test
  public void testLeftMoveFromWest() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.WEST));
    assertThat(rotateLeft.getNewPosition(testGame,COMMAND).getDirection(), is(Direction.SOUTH));

  }

  @Test
  public void testLeftMoveFromSouth() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.SOUTH));
    assertThat(rotateLeft.getNewPosition(testGame,COMMAND).getDirection(), is(Direction.EAST));

  }
  @Test(expected = NullPointerException.class)
  public void testNullDirection() {
    testGame.setRobotPosition(new RobotPosition(1, 2, null));
    assertNull(rotateLeft.getNewPosition(testGame,COMMAND).getDirection());

  }

}