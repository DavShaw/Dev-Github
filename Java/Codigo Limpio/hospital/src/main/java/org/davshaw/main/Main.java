package org.davshaw.main;

import java.io.IOException;
import java.sql.SQLException;

import org.davshaw.classes.Hospital;
import org.davshaw.external.TestCase;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException
    {
        Hospital hospital = new Hospital(11);
        TestCase.testData(hospital, 10);
        hospital.imprimirVisualizadorSolicitudes();
        hospital.deleteData();
        TestCase.testData(hospital, 10);
        hospital.imprimirVisualizadorSolicitudes();
    }
}
