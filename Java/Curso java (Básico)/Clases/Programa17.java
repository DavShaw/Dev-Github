import java.util.Scanner;


public class Programa17{
    public static void main(String args[]){

        try (Scanner input = new Scanner (System.in)) {
            //user_name must be just a name or an email
            String user_name_1 = "";
            String user_pass_1 = "";

            System.out.println("");
            System.out.println("********************************");
            System.out.println("DT Dev System - version: 1.0.263");
            System.out.println("********************************");
            System.out.println("");
            System.out.print("User name / E-Mail: ");
            user_name_1 = input.nextLine();
            System.out.print("Password: ");
            user_pass_1 = input.nextLine();

            if(user_name_1.equalsIgnoreCase("David") || user_name_1.equalsIgnoreCase("DavidTorres@gmail.com") && user_pass_1.equalsIgnoreCase("pass123")){
                System.out.println("");
                System.out.println("Successful system access.");
                System.out.println("Welcome back, " + user_name_1 + "!");
                System.out.println("");
                System.out.println("");
                System.out.println("That's your information");
                System.out.println("");
                System.out.println("==========================");
                System.out.println("Name: " + user_name_1);
                System.out.println("E-mail: " + user_name_1);
                System.out.println("Pass: *******" );
                System.out.println("==========================");
            } else {
                System.out.println("");
                System.out.println("Failed system access.");

            }
        }





    }
}
