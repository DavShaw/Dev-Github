package OOP.Triangulo;

public class Main
{
    public static void main(String[] args)
    {
        Triangle equilatero = new Triangle(5, 5, 5, 5, 10);
        System.out.println(equilatero.calcArea(true));
    }
}
