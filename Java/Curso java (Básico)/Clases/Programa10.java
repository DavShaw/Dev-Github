import java.util.Scanner;

public class Programa10{
    public static void main(String args[]){

        try (Scanner input = new Scanner(System.in)) {
            String user_name = "";
            int user_class_part = 10;

            System.out.println("===========================");
            System.out.println("¡Bienvenido al Programa" + user_class_part + "!");
            System.out.println("===========================");
            System.out.println("");
            System.out.println("");
            System.out.println("Antes de iniciar, ¿Cómo te llamas?");
            user_name = input.nextLine();
            System.out.println("");
            System.out.println("");
            System.out.println("¡Hola," + user_name + "! Esta clase / programa fue orientada a explicar y/o enseñar el código del programa 9, el cual afortunadamente tú realizaste con éxito. Felicidades... Att: David Torres");
        }
    }
}