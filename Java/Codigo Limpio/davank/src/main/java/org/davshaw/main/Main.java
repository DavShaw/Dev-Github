package org.davshaw.main;

import org.davshaw.classes.Cuenta;
import org.davshaw.controller.CuentaController;
import org.davshaw.controller.UsuarioController;
import org.davshaw.external.DataBase;

public class Main
{

    public static void main2(String[] args)
    {
        DataBase db = DataBase.getDataBase();
        db.executeUpdate("create table users (name text)");
    }

    public static void main(String[] args)
    {
    }
    
}