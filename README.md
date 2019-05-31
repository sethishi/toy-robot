### ToyRobot Simulator

Toyrobot simulator is designed to run in 2 modes.
1. File 
2. Console

#### Software Requirements
Java 8 

maven 3

#### Running Instructions

go to the project directory and run the following commands

1. ```mvn clean install``` 

2. ```mvn spring-boot:run```

Maven will run GameSimulator.java  

You will be prompted to choose the mode.
- Choose 1: File Input:  src/main/resources/input.txt
- Choose 2: Console Input


#### Scenarios covered in the input file

1. first command must be a PLACE
2. invalid place command, robot doesnt not move
3. move not possible, robot at the edge
4. invalid command, robot will not move
5. move steps one unit in the direction is if facing
6. left/right movement rotates the robot at 90 deg


#### Note
1. All the output console output
2. Errors are logged on console when they happen
3. Empty string input on console exits the program
4. Used lombok 
