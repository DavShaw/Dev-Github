import java.util.Scanner;

public class Programa11 {
    public static void main(String args[]){

        try (Scanner input = new Scanner(System.in)) {
            String user_name = "";
            int user_selection = 0;


            System.out.println("");
            System.out.println("==========================");
            System.out.println("Menú de inicio del sistema");
            System.out.println("==========================");
            System.out.println("");
            System.out.println("Por favor, indicanos tu nombre");
            System.out.println("");
            user_name = input.nextLine();
            System.out.println("");
            System.out.println("==============================");
            System.out.println("Hola, "+user_name+" bienvenido");
            System.out.println("==============================");
            System.out.println("");
            System.out.println("1) Te saludamos");
            System.out.println("2) Te insultamos");
            System.out.println("3) Te maldecimos");
            System.out.println("");
            System.out.println("Elige alguna de las anteriores opciones");
            System.out.println("");
            user_selection = input.nextInt();

            switch(user_selection){

                case 1: System.out.println("¡Hola! ¿Cómo has estado, " + user_name + "?");
                    break;


                case 2: System.out.println("Eres un doble, triple, sietemil veces hijueputa malparido, cacorro, " + user_name);
                    break;


                case 3: System.out.println("Opsalnle narigate incendum corpes " + user_name + ". Maretoh o'mallyz");
                    break;


            }
        }
    }
}
