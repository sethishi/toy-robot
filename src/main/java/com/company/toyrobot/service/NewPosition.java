package com.company.toyrobot.service;

import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;

public interface NewPosition {

   RobotPosition getNewPosition(Game game,String command);

}
