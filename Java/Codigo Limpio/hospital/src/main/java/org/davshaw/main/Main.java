package org.davshaw.main;

import org.davshaw.classes.Request;
import org.davshaw.classes.RequestQueue;

public class Main
{
    public static void main(String[] args)
    {

        RequestQueue Solicitudes = new RequestQueue(4);

        Request r1 = new Request("David", "Mareos", 3);
        Request r2 = new Request("Magola", "Dolor de huesos", 63);
        Request r3 = new Request("Sofia", "Cólicos", 35);
        Solicitudes.enqueue(r1);
        Solicitudes.enqueue(r2);
        Solicitudes.enqueue(r3);
        System.out.println(Solicitudes);
        Solicitudes.enqueue(new Request("Alfonsina", "Vómitos", 63));
        Solicitudes.removeRequestByID(1);


        /*
         * Con base a como fueron ingresados se espera:
         * David
         * Magola
         * Sofia
         * 
         * Con base al sort se espera:
         * Magola
         * Alfonsina
         * Sofia
         * David
         */
        System.out.println(Solicitudes);

    }

            public static int uwu(Integer age)
        {
            if (age >= 0 && age <= 120)
            {
                return 25 - age / 5;
            }
            
            else
            {
                return 25;
            }
        }
}
