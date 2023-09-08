package org.davshaw.main;

import java.io.IOException;
import java.sql.SQLException;

import org.davshaw.classes.Hospital;
import org.davshaw.external.ToSerializer;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException
    {
        Hospital hospital = new Hospital(4);
        hospital.agregarSolicitudes("Manuel", "Sin conexión", 52);
        hospital.agregarSolicitudes("Sofia", "Pantalla rota", 12);
        hospital.agregarSolicitudes("Estefani", "Pantalla azúl", 36);
        hospital.generateSerialized("hospital.txt");
        hospital.agregarSolicitudes("Jonathan","C#: Problemas de framework", 29);
        
        ToSerializer serializador = new ToSerializer("hospital.txt");
        Hospital nuevo = (Hospital) serializador.readObject();
        System.out.println(hospital.obtenerSolicitudes());
        System.out.println(nuevo.obtenerSolicitudes());

        

        


    }
}
