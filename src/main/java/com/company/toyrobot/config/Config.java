package com.company.toyrobot.config;

import com.company.toyrobot.domain.Table;
import com.company.toyrobot.service.ToyRobotGameImpl;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Value("${table.x}")
  int tablewidth;

  @Value("${table.y}")
  int tableHeight;

  @Bean(name = "squareTable")
  public Table table() {
    return new Table(tableHeight, tablewidth);
  }

//  @Bean(name = "game")
//  public ToyRobotGameImpl game() {
//    return new ToyRobotGameImpl();
//  }


//  @Bean
//  public MoveRightNewPosition moveRightNewPosition(){
//    return new MoveRightNewPosition(game());
//  }


}
