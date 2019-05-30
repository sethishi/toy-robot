package com.company.toyrobot.service;

import com.company.toyrobot.domain.Command;
import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;

public interface CommandAction {

  RobotPosition performAction(Game game,
                              String command);


}
