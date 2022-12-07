import java.util.Scanner;
public class Programa23{
    public static void main(String args[]){

        try (Scanner input = new Scanner(System.in)) {
            int up_slots = 0, side_slots = 0;
            System.out.print("Ingresa los slots en UP: ");
            up_slots = input.nextInt();
            System.out.println("");
            System.out.print("Ingresa los slots en SIDE: ");
            side_slots = input.nextInt();
            System.out.println("");
            System.out.println("UP tiene: " + up_slots + " slots y SIDE tiene: " + side_slots + ".");

            int contador = 0;
            int contador_incremento = 0;
            System.out.println("");
            System.out.println("El contador inicia con: ");
            contador = input.nextInt();
            System.out.println("");
            System.out.println("El contador incrementa en: ");
            contador_incremento = input.nextInt();
            System.out.println("");
            System.out.println("Counter starts: " + contador);
            System.out.println("Counter increments: " + contador_incremento);



            int numbers[][] = new int [up_slots][side_slots];


            for(int side_position = 0; side_position < side_slots ;side_position++){
                for(int up_position = 0; up_position < up_slots  ;up_position++){

                    numbers[up_position][side_position] = contador;
                    contador += contador_incremento;
                    System.out.print("[" + numbers[up_position][side_position] + "]");
                }
                System.out.println("");
            }
        }


    }
}
