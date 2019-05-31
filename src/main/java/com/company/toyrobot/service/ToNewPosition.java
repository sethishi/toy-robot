package com.company.toyrobot.service;

import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;

public interface ToNewPosition {

  RobotPosition getNewPosition(Game game, String command);

}
