package org.davshaw.classes.external;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

// By ChatGPT
public class ColorConsole {

    static {
        AnsiConsole.systemInstall();
    }

    public static String colorize(String text, String color) {
        Ansi.Color textColor = getColorByName(color);
        Ansi ansi = Ansi.ansi().fg(textColor).a(text).reset();
        return ansi.toString();
    }

    private static Ansi.Color getColorByName(String color) {
        switch (color.toLowerCase()) {
            case "black":
                return Ansi.Color.BLACK;
            case "red":
                return Ansi.Color.RED;
            case "green":
                return Ansi.Color.GREEN;
            case "yellow":
                return Ansi.Color.YELLOW;
            case "blue":
                return Ansi.Color.BLUE;
            case "magenta":
                return Ansi.Color.MAGENTA;
            case "cyan":
                return Ansi.Color.CYAN;
            case "white":
                return Ansi.Color.WHITE;
            default:
                return Ansi.Color.DEFAULT;
        }
    }
}
