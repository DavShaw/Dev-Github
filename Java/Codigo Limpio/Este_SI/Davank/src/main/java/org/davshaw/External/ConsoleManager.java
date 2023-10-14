package org.davshaw.External;

public class ConsoleManager {

    public static void clear() {
    try {
      // Si estamos en Windows, utiliza "cls"
      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      }
      // Si estamos en Unix o Linux, utiliza "clear"
      else {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
      }
    } catch (Exception e) {
      // Manejar cualquier excepción que pueda ocurrir al intentar limpiar la consola
      System.err.println("Error al limpiar la consola: " + e.getMessage());
    }
  }
}
