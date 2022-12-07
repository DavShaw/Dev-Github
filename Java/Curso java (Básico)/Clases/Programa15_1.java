public class Programa15_1{
    public static void main(String arg[]){

        int number = 0;

// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 con for - while - do while
        System.out.println("");
        System.out.println("Bucle con 'for'");
        for(number = 1 ; number <= 10 ; number +=1){
            if(number < 10){
                System.out.print(number + ", ");
            } else {
                System.out.print(number);
                System.out.println("");
            }
        }

        number = 1;
        System.out.println("");
        System.out.println("Bucle con 'while'");
        while(number <= 10){
            if(number < 10){
                System.out.print(number + ", ");
            } else {
                System.out.print(number);
                System.out.println("");
            }
            number += 1;
        }

        number = 1;
        System.out.println("");
        System.out.println("Bucle con do-while");
        do{
            if(number < 10){
                System.out.print(number + ", ");
            } else {
                System.out.print(number);
                System.out.println("");
            }
            number += 1;
        } while(number <= 10);



    }
}