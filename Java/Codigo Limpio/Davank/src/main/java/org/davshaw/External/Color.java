package org.davshaw.External;

import org.fusesource.jansi.Ansi;

public class Color {

  public static String color(String textColor, String message) {
    Ansi.Color ansiColor;

    try {
      ansiColor = Ansi.Color.valueOf(textColor.toUpperCase());
    } catch (IllegalArgumentException e) {
      ansiColor = Ansi.Color.WHITE;
    }

    return Ansi.ansi().fg(ansiColor).a(message).reset().toString();
  }
}
