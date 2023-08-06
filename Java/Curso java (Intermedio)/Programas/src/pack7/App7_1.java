package pack7;

import java.util.Scanner;

public class App7_1
{
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int area = 0;

            System.out.print("Enter base value: ");
            int base = input.nextInt();

            System.out.print("Enter height value: ");
            int height = input.nextInt();

            App7_2 imp = new App7_2(base,height, area);

            imp.Operation();
        }


    }
    
}
