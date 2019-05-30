package com.company.toyrobot.utils;

import com.company.toyrobot.domain.Direction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.EnumUtils.isValidEnum;

@Component
@Slf4j
public class HelperUtils {

  @Value("${table.x}")
  int tableWidth;
  @Value("${table.y}")
  int tableHeight;

  static int x;
  static int y;

  @PostConstruct
  public void init() {
    x = this.tableWidth;
    y = this.tableHeight;

  }

  private HelperUtils() {
  }

  static boolean isValid = false;

  public static boolean isValidPlaceCommand(String command) {

    Pattern p = Pattern.compile("^PLACE\\s\\d\\s\\d\\s\\D+");
    Matcher m = p.matcher(command);
    isValid = m.matches();


    if (isValid && isValidEnum(Direction.class, command.split(" ")[3])
        && Integer.valueOf(command.split(" ")[1]) <= x
        && Integer.valueOf(command.split(" ")[2]) <= y) {
      isValid = true;

    } else {
      isValid = false;
    }

    return isValid;

  }

  public static <T extends Enum<T>> T getEnumFromStr(Class<T> c, String string) {
    if (c != null && string != null) {
      try {
        return Enum.valueOf(c, string.trim().toUpperCase());
      } catch (IllegalArgumentException ex) {

      }
    }
    return null;
  }


}
