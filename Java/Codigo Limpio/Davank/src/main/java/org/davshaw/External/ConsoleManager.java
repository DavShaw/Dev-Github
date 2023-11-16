package org.davshaw.External;

public class ConsoleManager {

    // Console Manager -> By ChatGPT
    public static void clear() {
    try {
      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      }
      else {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
      }
    } catch (Exception e) {
      System.err.println("Error al limpiar la consola: " + e.getMessage());
    }
  }
}
