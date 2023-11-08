package org.davshaw.External;

public class Checker {

  public static Boolean isDigit(String value) {
    try {
      // Trying to casting to Integer
      Integer.parseInt(value);
      return true;
    } catch (NumberFormatException e1) {
      try {
        // Trying to casting to Float
        Float.parseFloat(value);
        return true;
      } catch (NumberFormatException e2) {
        try {
          // Trying to casting to Double
          Double.parseDouble(value);
          return true;
        } catch (NumberFormatException e3) {
          return false;
        }
      }
    }
  }
}
