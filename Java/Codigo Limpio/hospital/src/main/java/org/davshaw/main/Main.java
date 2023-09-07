package org.davshaw.main;

import org.davshaw.classes.Hospital;

public class Main
{
    public static void main(String[] args)
    {
        Hospital hospital = new Hospital(10000);
        hospital.agregarSolicitudes("David", "Mareos", 3);
        hospital.agregarSolicitudes("Magola", "Dolor de huesos", 63);
        hospital.agregarSolicitudes("Sofia", "Cólicos", 35);

    }
}
