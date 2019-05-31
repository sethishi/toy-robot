package com.company.toyrobot.service;

import com.company.toyrobot.domain.Direction;
import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import com.company.toyrobot.domain.Table;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoveToNewPositionTest {

  private static final RobotPosition defaultRobotPosition = new RobotPosition(0, 0, Direction.NORTH);
  private static final int UNITS = 4;
  private static final Table TEST_SQUARE_TABLE = new Table(UNITS, UNITS);
  private static final String COMMAND= "MOVE";

  private static final Game testGame = new Game(TEST_SQUARE_TABLE, defaultRobotPosition);
  private static final MoveToNewPosition moveNewPostion = new MoveToNewPosition();


  @Test
  public void testValidMoveToNorth() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.NORTH));
    assertThat(moveNewPostion.getNewPosition(testGame,COMMAND).getY(), is(3));
  }

  @Test
  public void testRobotDoesntMoveForInvalidMoveToNorth() {
    testGame.setRobotPosition(new RobotPosition(1, UNITS, Direction.NORTH));
    assertThat(moveNewPostion.getNewPosition(testGame,COMMAND).getY(), is(4));
  }

  @Test
  public void testValidMoveToEast() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.EAST));
    assertThat(moveNewPostion.getNewPosition(testGame,COMMAND).getX(), is(2));
  }

  @Test
  public void testRobotDoesntMoveForInvalidMoveToEast() {
    testGame.setRobotPosition(new RobotPosition(UNITS, 2, Direction.EAST));
    assertThat(moveNewPostion.getNewPosition(testGame,COMMAND).getX(), is(UNITS));
  }

  @Test
  public void testRobotDoesntMoveForInvalidMoveToWest() {
    testGame.setRobotPosition(new RobotPosition(0, 2, Direction.WEST));
    assertThat(moveNewPostion.getNewPosition(testGame,COMMAND).getX(), is(0));
  }

  @Test
  public void testRobotMovesWest() {
    testGame.setRobotPosition(new RobotPosition(3, 2, Direction.WEST));
    assertThat(moveNewPostion.getNewPosition(testGame,COMMAND).getX(), is(2));
  }

  @Test
  public void testRobotDoesntMoveForInvalidMoveToSouth() {
    testGame.setRobotPosition(new RobotPosition(0, 0, Direction.SOUTH));
    assertThat(moveNewPostion.getNewPosition(testGame,COMMAND).getY(), is(0));
  }

  @Test
  public void testRobotMovesSouth() {
    testGame.setRobotPosition(new RobotPosition(3, 2, Direction.SOUTH));
    assertThat(moveNewPostion.getNewPosition(testGame,COMMAND).getY(), is(1));
  }


}