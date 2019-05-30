package com.company.toyrobot.factory;

import com.company.toyrobot.domain.Command;
import com.company.toyrobot.service.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PositionFactory {

  /**
   * added explicitly to hide public constructor
   */
  private PositionFactory (){

  }
  static Map<String, NewPosition> newPostionMap = new HashMap<>();

  static {
    newPostionMap.put(Command.RIGHT.toString(), new MoveRightNewPosition());
    newPostionMap.put(Command.LEFT.toString(), new MoveLeftNewPosition());
    newPostionMap.put(Command.MOVE.toString(), new MoveNewPosition());
    newPostionMap.put(Command.PLACE.toString(), new MovePlaceNewPosition());
    newPostionMap.put(Command.REPORT.toString(), new MoveReportNewPosition());
  }

  public static Optional<NewPosition> getNewPosition(String command) {
    return Optional.ofNullable(newPostionMap.get(command));
  }

}
