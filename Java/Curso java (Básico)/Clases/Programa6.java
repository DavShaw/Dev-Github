public class Programa6{
    public static void main(String args[]){

        String user = "David";
        double spanish = 3.2;
        double english = 2.8;
        double math = 3;
        double promedio = 0;

        promedio = (spanish + english + math) /3;

        if(promedio >=3.5){
            System.out.println(user+" ¡has aprobado! (tu promedio es: "+promedio+")");
        } else {
            System.out.println(user+" ¡has reprobado!(tu promedio es: "+promedio+")");
        }
    }
}