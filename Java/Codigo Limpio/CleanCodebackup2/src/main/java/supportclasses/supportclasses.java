package supportClasses;
import java.util.List;

import classes.Habitacion;

public class supportclasses
{
    
    public static int getLongerList(List<List<Habitacion>> lista)
    {
        int longest = 0;

        for (List<Habitacion> list : lista)
        {
            if (list.size() > longest)
            {
                longest = list.size();
            }    
        }
        return longest;
    }

    public static Integer roundNumber(double number)
    {
        Integer roundedNumber = (int) Math.round(number);
        Double decimalNumber = number - roundedNumber;

        if (decimalNumber > 0.5)
        {
            return roundedNumber + 1;
        }

        else
        {
            return roundedNumber;
        }
    }






}
