import java.util.Scanner;

public class Programa9 {
    public static void main(String args[]){

        try (Scanner input = new Scanner(System.in)) {
            String user_name = "";
            int user_pass = 0;
            int user_working_time = 0;


            System.out.println("========================================");
            System.out.println("¡Bienvenido a Coca-Cola vacation system!");
            System.out.println("System version: BETA-9.0");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("Antes de continuar necesitamos que nos des información");
            System.out.println("");
            System.out.println("¿Cuál es tu nombre?");
            user_name = input.nextLine();
            System.out.println("¿Cuál es la clave de tu departamento?");
            user_pass = input.nextInt();
            System.out.println("¿Cuánto llevas laborando en Coca-Cola LLS?");
            user_working_time = input.nextInt();
            System.out.println("");
            System.out.println("");
//Primera clave 1 (Atención al cliente)
            if(user_pass == 1 && user_working_time == 1){
                System.out.println("=====================");
                System.out.println("Nombre: " + user_name);
                System.out.println("Dep. Atención al cliente (Clave " + user_pass + ")");
                System.out.println("Antiguedad: "+ user_working_time);
                System.out.println("");
                System.out.println("Días de vacaciones: 6 días");
                System.out.println("=====================");
            } else if(user_pass == 1 && user_working_time >=2 && user_working_time <=6){
                System.out.println("=====================");
                System.out.println("Nombre: " + user_name);
                System.out.println("Dep. Atención al cliente (Clave " + user_pass + ")");
                System.out.println("Antiguedad: "+ user_working_time);
                System.out.println("");
                System.out.println("Días de vacaciones: 14 días");
                System.out.println("=====================");
            } else if(user_pass == 1 && user_working_time >= 7){
                System.out.println("=====================");
                System.out.println("Nombre: " + user_name);
                System.out.println("Dep. Atención al cliente (Clave " + user_pass + ")");
                System.out.println("Antiguedad: "+ user_working_time);
                System.out.println("");
                System.out.println("Días de vacaciones: 20 días");
                System.out.println("=====================");
//Segunda clave (Lógistica)
            } else if(user_pass == 2 && user_working_time == 1){
                System.out.println("=====================");
                System.out.println("Nombre: " + user_name);
                System.out.println("Dep. Lógistica (Clave " + user_pass + ")");
                System.out.println("Antiguedad: "+ user_working_time);
                System.out.println("");
                System.out.println("Días de vacaciones: 7 días");
                System.out.println("=====================");
            } else if(user_pass == 2 && user_working_time >= 2 && user_working_time <= 6){
                System.out.println("=====================");
                System.out.println("Nombre: " + user_name);
                System.out.println("Dep. Lógistica (Clave " + user_pass + ")");
                System.out.println("Antiguedad: "+ user_working_time);
                System.out.println("");
                System.out.println("Días de vacaciones: 15 días");
                System.out.println("=====================");
            } else if(user_pass == 2 && user_working_time >= 7){
                System.out.println("=====================");
                System.out.println("Nombre: " + user_name);
                System.out.println("Dep. Lógistica (Clave " + user_pass + ")");
                System.out.println("Antiguedad: "+ user_working_time);
                System.out.println("");
                System.out.println("Días de vacaciones: 22 días");
                System.out.println("=====================");
//Tercera clave (Gerencia)
            } else if(user_pass == 3 && user_working_time == 1) {
                System.out.println("=====================");
                System.out.println("Nombre: " + user_name);
                System.out.println("Dep. Gerencia (Clave " + user_pass + ")");
                System.out.println("Antiguedad: "+ user_working_time);
                System.out.println("");
                System.out.println("Días de vacaciones: 10 días");
                System.out.println("=====================");
            } else if(user_pass == 3 && user_working_time >= 2 && user_working_time <= 6) {
                System.out.println("=====================");
                System.out.println("Nombre: " + user_name);
                System.out.println("Dep. Gerencia (Clave " + user_pass + ")");
                System.out.println("Antiguedad: "+ user_working_time);
                System.out.println("");
                System.out.println("Días de vacaciones: 20 días");
                System.out.println("=====================");
            } else if(user_pass == 3 && user_working_time >=7) {
                System.out.println("=====================");
                System.out.println("Nombre: " + user_name);
                System.out.println("Dep. Gerencia (Clave " + user_pass + ")");
                System.out.println("Antiguedad: "+ user_working_time);
                System.out.println("");
                System.out.println("Días de vacaciones: 30 días");
                System.out.println("=====================");
            } else {
                
                System.out.println("Error: información errada. Intenta nuevamente.");

            }
        }
    }
}
