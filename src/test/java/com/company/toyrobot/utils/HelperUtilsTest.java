package com.company.toyrobot.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HelperUtilsTest {


  @Test
  public void isValidPlaceCommand() {

    boolean validPlaceCommand = HelperUtils.isValidPlaceCommand("PLACE 1,2,NORTH");
    assertTrue(validPlaceCommand);
  }

  @Test
  public void isInValidPlaceCommand() {
    boolean validPlaceCommand = HelperUtils.isValidPlaceCommand("PLACE 1,2,NO");
    assertFalse(validPlaceCommand);
  }

  @Test
  public void getEnumFromStr() {

    TestEnum test3 = HelperUtils.getEnumFromStr(TestEnum.class, "TEST3");

    assertEquals(test3,TestEnum.TEST3);

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