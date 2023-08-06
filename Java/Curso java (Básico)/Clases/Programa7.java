public class Programa7 {
    public static void main(String args[]){

        int operation = 3;
        int number1 = 8;
        int number2 = 4;
        int result = 0;

        if(operation == 1){
            result = number1 + number2;
            System.out.println("El resultado de la suma es: "+ result);
            } else if(operation == 2){
                result = number1 - number2;
                System.out.println("El resultado de la resta es: "+ result);
            } else if(operation == 3){
                result = number1 * number2;
                System.out.println("El resultado de la multiplicación es: "+ result);
            } else if(operation == 4){
                result = number1 / number2;
                System.out.println("El resultado de la división es: "+ result);
            } else {
                System.out.println("Error: opción inválida. Intenta nuevamente.");
            }
        }
    }
