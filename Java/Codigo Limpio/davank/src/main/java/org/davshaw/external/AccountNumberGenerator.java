package org.davshaw.external;
import java.util.Random;

public class AccountNumberGenerator
{
    public static int generateNumber()
    {
        Random random = new Random();
        int min = 5000;
        int max = 2000000;
        return random.nextInt(max - min + 1) + min;
    }
}
