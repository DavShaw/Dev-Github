package pack8;

import java.util.Scanner;
import pack9.App9;

public class App8{

    public static void main(String[] args) {
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("\n\n====================\nExtreme Lavadora Samsung\n====================");
            System.out.print("\nIntroduce los kilos de ropa (1 a 12): ");
            int KilosDeRopa = input.nextInt();

            System.out.println("\nPulsa 0 - Ropa blanca | Pulsa 1 - Ropa de color");
            System.out.print("Ingresa el tipo de ropa: ");
            int TipoDeRopa = input.nextInt();
            System.out.println("\n");

            App9 imp = new App9(KilosDeRopa, TipoDeRopa);


            imp.setTipoDeRopa(1);

            imp.CicloFinalizado();

            System.out.println("\nSudo: el tipo de ropa ha sido forzado por los dev y ha cambiado a: " + imp.getTipoDeRopa());
        }
    }
    
}
