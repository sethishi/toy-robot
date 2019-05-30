package com.company.toyrobot.input;

import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import com.company.toyrobot.service.CommandActionImpl;
import com.company.toyrobot.service.ToyRobotGameImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

import static com.company.toyrobot.utils.HelperUtils.isValidPlaceCommand;

@Service
@Slf4j
public class ConsoleInputScanner implements InputScanner {

  @Autowired
  private ToyRobotGameImpl playGame;

  @Autowired
  CommandActionImpl commandAction;

  private static Scanner scanner = new Scanner(System.in);
  private boolean truefalse = true;

  /**
   * Console accepts input commands until and empty string is passed
   */
  @Override
  public void readInput() {

    String firstCommand = scanner.nextLine();
    boolean b = false;

    b = isValidPlaceCommand(firstCommand);
    while (!b) {
      log.error("first command must be a valid PLACE command <PLACE 1,2,NORTH>");
      firstCommand = scanner.nextLine();
      b = isValidPlaceCommand(firstCommand);
    }

    Game newGame = playGame.start(firstCommand);

    while (truefalse) {
      String command = scanner.nextLine();
      if (command.equals("")) {
        truefalse = false;
      } else if (isValidPlaceCommand(command)) {
       newGame= playGame.start(command);
        playGame(newGame, command);
      } else {
        playGame(newGame, command);
      }
    }
    scanner.close();

  }

  private void playGame(Game newGame, String command) {

    RobotPosition robotPosition = commandAction.performAction(newGame,command);
    newGame.setRobotPosition(robotPosition);
  }
}
