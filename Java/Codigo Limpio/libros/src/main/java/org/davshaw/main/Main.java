package org.davshaw.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.davshaw.external.DataBase;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        DataBase db = new DataBase
        (
        "containers-us-west-31.railway.app",
        6986,
        "railway",
        "root",
        "IIBDbFM36RhcoMDL5WyQ"
        );


        //Main.e1(db, 5);
        Main.e2(db,"Paulo Coelho");

        
    }

    public static void e1(DataBase db, int idLibro) throws SQLException
    {
        String sql = ("SELECT release_date from books where id = " + idLibro);
        ResultSet result = db.executeQuery(sql);
        result.next();
        System.out.println("El libro de ID " + idLibro + "Se publico " + result.getString(1));

    }

    public static void e2(DataBase db, String nombreAutor) throws SQLException
    {
        String sql = String.format("select * from books where author = '%s'", nombreAutor);
        ResultSet result = db.executeQuery(sql);
    
        // Verifica si hay al menos un libro
        if (!result.isBeforeFirst())
        {
            System.out.println("No se encontraron libros para el autor: " + nombreAutor);
            return;
        }
    
        System.out.println("Los libros del autor llamado " + nombreAutor + " son: ");
    
        while (result.next())
        {
            System.out.println(result.getString("title"));
        }
    }
    
}