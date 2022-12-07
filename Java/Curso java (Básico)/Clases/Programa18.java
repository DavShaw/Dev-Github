import java.util.Scanner;

public class Programa18{
    public static void main(String args[]){

        try (Scanner input = new Scanner(System.in)) {
            String user_input_string = "";
            String user_input_string_substract = "";
            
            int user_input_int_start = 0;
            int user_input_int_end = 0;
            int admin_string_number = 0;


            System.out.println("");
            System.out.println("==============================");
            System.out.println("Bienvenido al menú del sistema");
            System.out.println("==============================");
            System.out.println("");
            System.out.print("Ingresa una linea de texto: ");
            user_input_string = input.nextLine();
            System.out.println("");
            System.out.println("");
            admin_string_number = user_input_string.length(); 
            System.out.println("La linea de texto que escribiste tiene " + admin_string_number + " carácteres.");
            System.out.println("");
            System.out.println("=======================================================");
            System.out.println("");
            System.out.println("¡Hey! Vamos a extraer un poco del texto que escribiste anteriormente");
            System.out.println("");
            System.out.print("Iniciar a extraer desde: ");
            user_input_int_start = input.nextInt();
            System.out.print("Finalizar de extraer hasta: ");
            user_input_int_end = input.nextInt();
            System.out.println("");
            user_input_string_substract = user_input_string.substring(user_input_int_start,user_input_int_end);
            System.out.println("Se extrajó: '" + user_input_string_substract + "' del texto");
        }




    }
}
