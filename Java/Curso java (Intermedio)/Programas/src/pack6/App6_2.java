package pack6;

public class App6_2
{
    private int v1, v2, result;
    public App6_2(int v1, int v2)
    {
        this.v1 = v1;
        this.v2 = v2;
    }

    public void Operation()
    {
        result = v1 + v2;
        System.out.println("\n\n==================================\nThe result of the addition is: " + result+"\n==================================");
    }
}
