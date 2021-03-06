package com.company.toyrobot.service;

import com.company.toyrobot.domain.Direction;
import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import com.company.toyrobot.domain.Table;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PlaceToNewPositionTest {

  private static final RobotPosition defaultRobotPosition = new RobotPosition(0, 0, Direction.NORTH);
  private static final int UNITS = 4;
  private static final Table TEST_SQUARE_TABLE = new Table(UNITS, UNITS);
  private static final String COMMAND= "PLACE 0,0,NORTH";

  private static final Game testGame = new Game(TEST_SQUARE_TABLE, defaultRobotPosition);
  private static final PlaceToNewPosition moveNewPostion = new PlaceToNewPosition();


  @Test
  public void testValidPlaceMoveStartsNewGame() {
    testGame.setRobotPosition(new RobotPosition(1, 2, Direction.NORTH));
    assertThat(moveNewPostion.getNewPosition(testGame,COMMAND).getY(), is(0));
    assertThat(moveNewPostion.getNewPosition(testGame,COMMAND).getX(), is(0));
  }


}