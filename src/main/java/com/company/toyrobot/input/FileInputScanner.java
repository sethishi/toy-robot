package com.company.toyrobot.input;

import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import com.company.toyrobot.service.CommandActionImpl;
import com.company.toyrobot.service.ToyRobotGameImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.company.toyrobot.utils.HelperUtils.isValidPlaceCommand;

@Service
@Slf4j
public class FileInputScanner implements InputScanner {

  @Autowired
  private ToyRobotGameImpl toyRobotGame;

  @Autowired
  CommandActionImpl commandAction;

//  @Autowired
//  Game game;

  private static Scanner scanner;

  static {
    try {
      scanner = new Scanner(getFile());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static boolean truefalse = true;

  @Override
  public void readInput() {
    String firstCommand = scanner.nextLine();
    boolean b = false;

    b = isValidPlaceCommand(firstCommand);
    while (!b) {
      System.out.println(firstCommand);
      log.error("first command must be a valid PLACE command <PLACE 1,2,NORTH>");
      firstCommand = scanner.nextLine();
      b = isValidPlaceCommand(firstCommand);
    }
    System.out.println(firstCommand);
    Game newGame = toyRobotGame.start(firstCommand);

    while (scanner.hasNext()) {
      String command = scanner.nextLine();
      if (isValidPlaceCommand((command))) {
        System.out.println(command);
        newGame = toyRobotGame.start(command);
      } else {
        System.out.println(command);
        playGame(newGame, command);
      }
    }
    scanner.close();
  }

  private static File getFile() {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    return new File(classLoader.getResource("input.txt").getFile());
  }

  private void playGame(Game newGame, String command) {

    RobotPosition robotPosition = commandAction.performAction(newGame, command);
    newGame.setRobotPosition(robotPosition);
  }
}
