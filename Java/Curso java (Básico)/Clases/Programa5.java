public class Programa5{
    public static void main(String args[]){

        
        int number1 = 2;
        int number2 = 8;
        int result = 0;


        result = number1 + number2 / 2;
        System.out.println("El resultado (Con jerarquía) de "+ number1 +" + "+ number2 + " es igual a: "+ result);

        result = (number1 + number2) /2;
        System.out.println("El resultado (Sin jerarquía) de "+ number1 +" + "+ number2 + " es igual a: "+ result);
    }
}