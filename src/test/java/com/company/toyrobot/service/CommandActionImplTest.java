package com.company.toyrobot.service;

import com.company.toyrobot.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@DirtiesContext
public class CommandActionImplTest {

  private static RobotPosition defaultRobotPosition = new RobotPosition(0, 0, Direction.NORTH);
  private static int UNITS = 4;
  private static Table TEST_SQUARE_TABLE = new Table(UNITS, UNITS);


  private static Game testGame = new Game(TEST_SQUARE_TABLE, defaultRobotPosition);

  CommandActionImpl commandAction = new CommandActionImpl();

  @Test
  public void testLeftMoveIsCalledCorrectly() {
    assertThat(commandAction.performAction(testGame, Command.LEFT.toString()).getDirection()).isEqualTo(Direction.WEST);
    assertThat(commandAction.performAction(testGame, Command.RIGHT.toString()).getDirection()).isEqualTo(Direction.EAST);
    assertThat(commandAction.performAction(testGame, Command.MOVE.toString()).getX()).isEqualTo(0);
    assertThat(commandAction.performAction(testGame, Command.MOVE.toString()).getY()).isEqualTo(1);
  }

  @Test
  public void testInvalidMoveDoesntChangePosition() {
    assertThat(commandAction.performAction(testGame, "INVALID").getDirection()).isEqualTo(Direction.NORTH);
  }

  @Test
  public void testInvalidPlaceCommandDoesntChangePosition() {
    assertThat(commandAction.performAction(testGame, "PLACE 1,6").getDirection()).isEqualTo(Direction.NORTH);
    assertThat(commandAction.performAction(testGame, "PLACE 1,2,TW").getDirection()).isEqualTo(Direction.NORTH);
  }

  @Test
  public void testValidPlaceCommand() {
    assertThat(commandAction.performAction(testGame, "PLACE 2,0,EAST").getDirection()).isEqualTo(Direction.EAST);
  }
}