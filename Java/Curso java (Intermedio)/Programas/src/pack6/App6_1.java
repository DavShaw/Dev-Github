package pack6;

import java.util.Scanner;
public class App6_1 {
    public static void main(String args[]){
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("\n\n==========================\nLet's make an Addition!\n==========================\n");
            System.out.print("Enter 1st vaule: ");
            int v1 = input.nextInt();
            System.out.print("Enter 1st vaule: ");
            int v2 = input.nextInt();
            
            App6_2 imp = new App6_2(v1,v2);

            imp.Operation();
        }

    }
    
}
