package com.company.toyrobot.service;

import com.company.toyrobot.domain.Game;

import java.util.Optional;

class Rotate {

  Optional<Short> getRobotDirection(Game game) {
    return Optional.of(game.getRobotPosition().getDirection().getLocation());
  }

}
