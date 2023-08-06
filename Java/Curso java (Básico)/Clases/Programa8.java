import java.util.Scanner;

public class Programa8{
    public static void main(String args[]){
        
        try (Scanner input = new Scanner(System.in)) {
          String user_name = "";
          int n1 = 0;
          int n2 = 0;
          int result = 0;

          System.out.println("========================");
          System.out.println("¡Bienvenido al programa!");
          System.out.println("========================");
          System.out.println("");
          System.out.println("¿Cuál es tu nombre?: "); 
          System.out.println("");
          user_name = input.nextLine();
          System.out.println("");
          System.out.println("Introduce el primer número: ");  
          System.out.println("");
          n1 = input.nextInt();
          System.out.println("");
          System.out.println("Introduce el segundo número"); 
          System.out.println("");
          n2 = input.nextInt();
          result = n1 + n2;
          System.out.println("");
          System.out.println("");
          System.out.println("");
          System.out.println(user_name+", el resultado de "+n1+" + "+n2+ " es: "+result);
   //user_name = input.nextInt(); - Esto se usa para guardar datos de tipo número.
        }

    }
}