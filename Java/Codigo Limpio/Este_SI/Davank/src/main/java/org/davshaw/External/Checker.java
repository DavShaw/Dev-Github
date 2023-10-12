package org.davshaw.External;

public class Checker
{
    public static Boolean isDigit(String value)
    {
        try
        {
            @SuppressWarnings("unused")
            Integer caster = Integer.parseInt(value);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
