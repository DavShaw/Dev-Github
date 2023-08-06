import java.util.Scanner;
public class Programa20{
    public static void main(String args[]){

        int vector_slots = 0;
        int vector_position = 0;
        int vector_position_content = 0;

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("");
            System.out.println("Bienvenido, vamos a crear vectores");
            System.out.println("");
            System.out.print("Ingresa los slots máximos (0 - 100): ");
            vector_slots = input.nextInt();
            System.out.println("");
            System.out.println("El vector tiene " + vector_slots + " ranuras");
            System.out.println("");
            
            int cell_numbers[] = new int[vector_slots];

            for(vector_position = 0; vector_position < vector_slots; vector_position += 1){
                System.out.println("");
                System.out.print("Guarda datos en ranura " + vector_position + ": ");
                vector_position_content = input.nextInt();
                cell_numbers[vector_position] = vector_position_content;

                System.out.println("");
            }

            for(vector_position = 0; vector_position < vector_slots ; vector_position += 1){
                System.out.print("[" + cell_numbers[vector_position] + "] ");

            }
        }



    }
}