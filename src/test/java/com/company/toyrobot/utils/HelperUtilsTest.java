package com.company.toyrobot.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelperUtilsTest {


  @Test
  public void isValidPlaceCommand() {

    HelperUtils.x = 4;
    HelperUtils.y = 4;
    boolean validPlaceCommand = HelperUtils.isValidPlaceCommand("PLACE 1 2 NORTH");

    assertTrue(validPlaceCommand);


  }

  @Test
  public void isInValidPlaceCommand() {
    boolean validPlaceCommand = HelperUtils.isValidPlaceCommand("PLACE 1 2 NO");
    assertFalse(validPlaceCommand);
  }

  @Test
  public void getEnumFromStr() {

    TestEnum test3 = HelperUtils.getEnumFromStr(TestEnum.class, "TEST3");

    assertTrue(test3.equals(TestEnum.TEST3));

  }

  @Test
  public void getInvalidEnumFromStr() {
    TestEnum test3 = HelperUtils.getEnumFromStr(TestEnum.class, "TESTINVALID");
    assertNull(test3);

  }

  enum TestEnum {
    TEST1, TEST2, TEST3
  }
}