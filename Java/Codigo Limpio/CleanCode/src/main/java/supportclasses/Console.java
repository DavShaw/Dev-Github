package supportclasses;

public class Console
{

    public static void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void spaces(int spaces)
    {
        for (int i = 0; i < spaces; i++)
        {
            System.out.println(" ");
        }
    }
    

}
