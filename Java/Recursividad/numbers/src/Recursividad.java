public class Recursividad
{
    public static int factorial(int number)
    {   
        if (number < 0)
        {
            throw new IllegalArgumentException("Input cannot be a", null);
        }


        else if (number == 0)
        {
            return 1;
        }

        else
        {
            return number * factorial(number-1);
        }
    }

    public static void main(String[] args) {
        
        int test = factorial(-1);

        System.out.println(test);
    }
}
