package org.davshaw.main;

import java.io.IOException;
import java.sql.SQLException;

import org.davshaw.classes.Hospital;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException
    {
        Hospital hospital = new Hospital(11);
        hospital.testData(10);
        hospital.imprimirVisualizadorSolicitudes();
        hospital.deleteData();
        hospital.testData(10);
        hospital.imprimirVisualizadorSolicitudes();
    }
}
