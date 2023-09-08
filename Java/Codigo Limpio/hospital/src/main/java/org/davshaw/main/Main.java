package org.davshaw.main;

import java.io.IOException;
import java.sql.SQLException;

import org.davshaw.classes.Hospital;
import org.davshaw.classes.RequestQueue;
import org.davshaw.external.DataBase;
import org.davshaw.external.QueueFromDatabase;
import org.davshaw.resources.TestData;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException
    {
        Hospital hospital = new Hospital(6);
        hospital.agregarSolicitudes("David", "Mareos", 3);
        hospital.agregarSolicitudes("Magola", "Dolor de huesos", 63);
        hospital.agregarSolicitudes("Sofia", "Cólicos", 35);
        hospital.agregarSolicitudes("Jonathan", "Ni el sabe", 105);

        DataBase db = new TestData().getDatabase();
        RequestQueue queue = new QueueFromDatabase(db).getRequestQueue();
        System.out.println(queue);


    }
}
