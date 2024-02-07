package es.codegym.telegrambot;

import java.util.List;

public class TelegramBotContent {

  public static final List<String> MENU_OPTIONS = List.of(
    "1 - Informacion del bot",
    "2 - Jugar",
    "3 - Borrar mensajes",
    "4 - Salir"
  );

  public static String getBotMainMessage(String username, String botName) {
    String menu = String.join("\n", MENU_OPTIONS);
    return """
      Hackeando a @%s
      Me presento, soy un bot de Telegram. Soy un audaz hacker. Me llamo @%s.

      Por favor, elige una de las siguientes opciones:
      %s
        """.formatted(
        username,
        botName,
        menu
      );
  }

  public static final String STEP_1_TEXT =
    """
             *BIENVENIDO AL NIVEL UNO!*   
             
             Te despiertas y te das cuenta de que eres un gato. Es una buena manana, pero que son estos extranos sentimientos? Tu estomago esta rugiendo de hambre. No hay comida en el apartamento, excepto en la nevera cerrada. Que hacer?
             Tendras que recordar como piratear la nevera digital. Abre el libro "Hacking Avanzado para Gatos":
             
                 1. Completa la primera tarea y luego pasa la pagina.
                 2. Avanza y ve a lo mas interesante.
                 3. Realiza acciones para ganarte el respeto de todos los gatos locales.
                 
             *Gato domestico comun, nivel uno.*
             
             Hackea la nevera digital y completa la primera tarea!
             
             """;

  public static final String STEP_2_TEXT =
    """
             *BIENVENIDO AL SEGUNDO NIVEL!*
             
             Bien! Has derrotado la nevera. Ganas +20 de fama!
             
             _Acumulado: 20 de fama._
             
             Elige tu recompensa:

             """;

  public static final String STEP_3_TEXT =
    """
            *Gato programador, nivel dos.*
            De repente, desde la esquina, aparecio un robot aspiradora zumbante. Es hora de vengarse!
            Completa la segunda tarea y hackealo!
            """;

  public static final String STEP_4_TEXT =
    """
             *BIENVENIDO AL TERCER NIVEL!*
             
             Has derrotado al robot aspiradora! Ganas +30 de fama!
             
             _Acumulado: 70 de fama._
             
             Elige tu recompensa:

             """;

  public static final String STEP_5_TEXT =
    """
            *Gato Robosubyugador, nivel tres.*
            Jaja! Se encontro una GoPro abandonada en el estante!
            Completa la tercera tarea: pontela y enciendela!
            """;

  public static final String STEP_6_TEXT =
    """
             *BIENVENIDO AL CUARTO NIVEL!*
                                    
             Te pusiste la GoPro! Ganas +40 de fama!
                                    
             _Acumulado: 140 de fama._
            
             Elige tu recompensa:

             """;

  public static final String STEP_7_TEXT =
    """
            *Gato Videobloguero, nivel cuatro.*
            Ahora, el material grabado debe ser transferido a la computadora.
            Completa la cuarta tarea: hackea la contrasena de la computadora!
            """;

  public static final String STEP_8_TEXT =
    """
             *BIENVENIDO AL QUINTO NIVEL!*
            
             Has superado la computadora! Ganas +50 de fama!
            
             _Acumulado: 230 de fama._

             """;

  public static final String FINAL_TEXT =
    """
            *Gato Hacker, nivel cinco.*
            El dia no paso en vano: el gato hacker tomo medidas y gano el respeto de los gatos callejeros locales.
            """;
}
