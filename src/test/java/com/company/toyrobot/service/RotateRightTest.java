package com.company.toyrobot.service;

import com.company.toyrobot.domain.Direction;
import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import com.company.toyrobot.domain.Table;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RotateRightTest {

  private static final RobotPosition defaultRobotPosition = new RobotPosition(0, 0, Direction.NORTH);
  private static final int UNITS = 4;
  private static final Table TEST_SQUARE_TABLE = new Table(UNITS, UNITS);
  private static final RotateRight rotateRight = new RotateRight();
  private static final String COMMAND = "RIGHT";

  private static Game testGame = new Game(TEST_SQUARE_TABLE, defaultRobotPosition);

  @Test
  public void testRightMoveFromNorth() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.NORTH));
    assertThat(rotateRight.getNewPosition(testGame,COMMAND).getDirection(), is(Direction.EAST));

  }

  @Test
  public void testRightMoveFromEast() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.EAST));
    assertThat(rotateRight.getNewPosition(testGame,COMMAND).getDirection(), is(Direction.SOUTH));

  }

  @Test
  public void testRightMoveFromWest() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.WEST));
    assertThat(rotateRight.getNewPosition(testGame,COMMAND).getDirection(), is(Direction.NORTH));

  }

  @Test
  public void testRightMoveFromSouth() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.SOUTH));
    assertThat(rotateRight.getNewPosition(testGame,COMMAND).getDirection(), is(Direction.WEST));

  }

  @Test(expected = NullPointerException.class)
  public void testNullDirection() {
    testGame.setRobotPosition(new RobotPosition(1, 2, null));
    assertNull(rotateRight.getNewPosition(testGame,COMMAND).getDirection());

  }


}