package com.company.toyrobot.service;

import com.company.toyrobot.domain.Game;

import java.util.Optional;

public class Rotate {


  protected Optional<Short> getRobotDirection(Game game) {
    return Optional.ofNullable(game.getRobotPosition().getDirection().getLocation());
  }

}
