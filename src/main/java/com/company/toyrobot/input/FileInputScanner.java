package com.company.toyrobot.input;

import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import com.company.toyrobot.service.CommandActionImpl;
import com.company.toyrobot.service.ToyRobotGameImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.company.toyrobot.utils.HelperUtils.isValidPlaceCommand;

@Service
public class FileInputScanner implements InputScanner {

  @Autowired
  private ToyRobotGameImpl toyRobotGame;

  @Autowired
  CommandActionImpl commandAction;

  @Autowired
  Game game;

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
      firstCommand = scanner.nextLine();
      b = isValidPlaceCommand(firstCommand);
    }

    game = toyRobotGame.start(firstCommand);

    while (scanner.hasNext()) {
      String command = scanner.nextLine();
      if (isValidPlaceCommand((command))) {
        Game start = toyRobotGame.start(command);
      }

      RobotPosition robotPosition = commandAction.performAction(game, command);
      game.setRobotPosition(robotPosition);
      System.out.println(game);

    }
    scanner.close();
  }

  private static File getFile() {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    return new File(classLoader.getResource("input.txt").getFile());
  }
}
