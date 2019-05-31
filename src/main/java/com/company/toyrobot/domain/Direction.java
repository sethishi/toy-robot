package com.company.toyrobot.domain;

public enum Direction {

  NORTH ((short)1), EAST((short)2),SOUTH((short) 3),WEST((short) 4);

  private final short location;

  Direction(short location) {
    this.location = location;
  }

  public short getLocation() {
    return location;
  }

  public static Direction getEnumFromValue(short location){
    Direction[] directions = Direction.values();
    for (Direction d : directions){
      if(d.getLocation()==location){
        return d;
      }
    }
    return null;
  }
}
