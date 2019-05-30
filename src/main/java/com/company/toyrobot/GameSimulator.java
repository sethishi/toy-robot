package com.company.toyrobot;

import com.company.toyrobot.input.ConsoleInputScanner;
import com.company.toyrobot.input.FileInputScanner;
import com.company.toyrobot.input.InputScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@SpringBootApplication
public class GameSimulator {

  private static InputScanner fileInputScanner;
  private static InputScanner consoleInputScanner;

  @Autowired
   FileInputScanner getFileInputScanner;
  @Autowired
  ConsoleInputScanner getConsoleInputScanner;

  @PostConstruct
  private void init() {
    fileInputScanner = this.getFileInputScanner;

    consoleInputScanner= this.getConsoleInputScanner;
  }


  public static void main(String[] args) {
    SpringApplication.run(GameSimulator.class, args);


    System.out.println("choose input source : ");
    System.out.println("[1] - FILE");
    System.out.println("[2] - CONSOLE ");

    Scanner input = new Scanner(System.in);

    boolean isValidSource = false;
    int inputChoice = 0;

    while (!isValidSource) {
      inputChoice = input.nextInt();
      System.out.println(inputChoice);

      if (inputChoice == 1 || inputChoice == 2) {
        isValidSource = true;
      } else {
        System.out.println("Enter a valid number");
      }
    }
    if (inputChoice == 2) {
      consoleInputScanner.readInput();

    } else {
      fileInputScanner.readInput();
    }
  }


}



