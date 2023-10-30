package org.davshaw.External;

public class Checker {

  public static Boolean isDigit(String value) {
    try {
      // Intenta convertir a Integer
      Integer.parseInt(value);
      return true;
    } catch (NumberFormatException e1) {
      try {
        // Intenta convertir a float
        Float.parseFloat(value);
        return true;
      } catch (NumberFormatException e2) {
        try {
          // Intenta convertir a Double
          Double.parseDouble(value);
          return true;
        } catch (NumberFormatException e3) {
          return false;
        }
      }
    }
  }
}
