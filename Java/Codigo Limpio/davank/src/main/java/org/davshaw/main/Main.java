package org.davshaw.main;

import org.davshaw.controller.GrupoController;
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
        GrupoController groupController = new GrupoController();
        System.out.println(groupController.obtenersaldo(1));
        
    }
    
}