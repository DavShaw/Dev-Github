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
        Main.e2(db,"James Joyce");

        
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
        String sql = ("SELECT * from books where author != 'James Joyce'");
        ResultSet result = db.executeQuery(sql);
        result.next();
        System.out.println("Los libros del autor llamado " + nombreAutor + " son: ");

        while (result.next())
        {
            System.out.println(result.getString("title"));
        }

    }
}