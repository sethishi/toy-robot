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
  private static final Map<String, ToNewPosition> newPostionMap = new HashMap<>();

  static {
    newPostionMap.put(Command.RIGHT.toString(), new RotateRight());
    newPostionMap.put(Command.LEFT.toString(), new RotateLeft());
    newPostionMap.put(Command.MOVE.toString(), new MoveToNewPosition());
    newPostionMap.put(Command.PLACE.toString(), new PlaceToNewPosition());
    newPostionMap.put(Command.REPORT.toString(), new MoveReportToNewPosition());
  }

  public static Optional<ToNewPosition> getNewPosition(String command) {
    return Optional.ofNullable(newPostionMap.get(command));
  }

}
