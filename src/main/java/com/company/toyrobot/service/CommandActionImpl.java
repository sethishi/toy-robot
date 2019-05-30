package com.company.toyrobot.service;

import com.company.toyrobot.domain.Command;
import com.company.toyrobot.domain.Game;
import com.company.toyrobot.domain.RobotPosition;
import com.company.toyrobot.factory.PositionFactory;
import com.company.toyrobot.utils.HelperUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.company.toyrobot.factory.PositionFactory.getNewPosition;
import static com.company.toyrobot.utils.HelperUtils.isValidPlaceCommand;

@Service
@Slf4j
public class CommandActionImpl implements CommandAction {

  @Autowired
  private Game game;

  public RobotPosition performAction(Game game, String command) {

    if("PLACE".equals(command.split(" ")[0]) && !isValidPlaceCommand(command)){
      log.error("invalid place command, robot will not move");
      return game.getRobotPosition();
    }

    if (EnumUtils.isValidEnum(Command.class, command.split(" ")[0])) {
      Optional<NewPosition> newPosition = getNewPosition(command.split(" ")[0]);
      if (newPosition.isPresent()) {
        return newPosition.get().getNewPosition(game, command);
      }else {
        log.error("invalid command, robot will not move");
      }
    } else {
      log.error("invalid command, robot will not move");
    }
    return game.getRobotPosition();

  }
}
