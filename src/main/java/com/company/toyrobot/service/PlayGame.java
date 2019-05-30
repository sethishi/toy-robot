package com.company.toyrobot.service;

import com.company.toyrobot.domain.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public abstract class PlayGame {

  public abstract Game start(String command);
  public abstract Game reset();


}
