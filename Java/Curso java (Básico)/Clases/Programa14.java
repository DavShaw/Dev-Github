import java.util.Scanner;
public class Programa14{
    public static void main(String args[]){
        try (Scanner input = new Scanner(System.in)) {
            long user_int_input1 = 0, user_int_input2 = 0, user_int_input3 = 0;

            System.out.print("No. Inicial: ");
            user_int_input1 = input.nextLong();
            System.out.print("No. de incremento: ");
            user_int_input2 = input.nextLong();
            System.out.print("No. máximo del codigo: ");
            user_int_input3 = input.nextLong();

            do{
                System.out.print(user_int_input1 + ", ");
                user_int_input1 += user_int_input2;

            }while(user_int_input1 <= user_int_input3);
        }
    }
}
