public class Programa15_2{
    public static void main(String args[]){

        int n1 = 1, n2 = 99;

// 1, 99, 2, 98, 3, 97, 4, 96, 5, 95 con for - while - do while
        System.out.println("");
        System.out.println("Bucle con 'for'");
        for(n1 = 1 ; n1 <= 5 ; n1 +=1){
            if(n1 < 5){
                System.out.print(n1 + ", ");
                System.out.print(n2 + ", ");
            } else {
                System.out.print(n1 + ", ");
                System.out.print(n2);
            }
            n2 -= 1;
        }
        n1 = 1;
        n2 = 99;
        System.out.println("");
        System.out.println("");
        System.out.println("Bucle con 'while");

        while(n1 <= 5){
            if(n1 < 5){
                System.out.print(n1 + ", ");
                System.out.print(n2 + ", ");
                n1 += 1;
            } else {
                System.out.print(n1 + ", ");
                System.out.print(n2 );
                break;

            }
            n2 -= 1;
        }

        n1 = 1;
        n2 = 99;
        System.out.println("");
        System.out.println("");
        System.out.println("Bucle con 'do-while'");

        do{
            if(n1 < 5){
                System.out.print(n1 + ", ");
                System.out.print(n2 + ",");
                n1 += 1;
            } else {
                System.out.print(n1 + ", ");
                System.out.print(n2);
                break;
            }
            n2 -= 1;
        } while(n1 <= 5);





    }
}