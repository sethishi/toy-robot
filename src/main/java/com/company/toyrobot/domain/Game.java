package com.company.toyrobot.domain;


import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Game {

  private Table table;
  private RobotPosition robotPosition;

  public void setRobotPosition(RobotPosition robotPosition) {
    this.robotPosition = robotPosition;
  }
}
