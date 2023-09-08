package org.davshaw.external;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.davshaw.classes.Request;
import org.davshaw.classes.RequestQueue;
import org.davshaw.resources.TestData;

public class QueueFromDatabase
{
    private DataBase db;
    private RequestQueue requestQueue;
    private ResultSet queryResult;
    
    public QueueFromDatabase(DataBase db)
    {
        this.db = db;
        
    }

    private void addQueryResultToQueue() throws SQLException
    {
        this.queryResult = this.db.executeQuery("SELECT * FROM requestDatabase");
        int querySize = this.getQuerySize(queryResult);
        this.requestQueue = new RequestQueue(querySize);
        while (this.queryResult.next())
        {
            String name = this.queryResult.getString("name");
            String description = this.queryResult.getString("requestDescription");
            int age = this.queryResult.getInt("age");

            //Instanciar objeto
            Request requestToAdd = new Request(name, description, age);
            //Añadir a la requestQueue
            this.requestQueue.enqueue(requestToAdd);
        }
        this.queryResult.close();
    }

    private int getQuerySize(ResultSet resultSet) throws SQLException
    {
        int rowCount = 0;
        if (resultSet != null)
        {
            resultSet.last(); // Mueve el cursor al final del ResultSet
            rowCount = resultSet.getRow(); // Obtiene el número de fila actual
            resultSet.beforeFirst(); // Vuelve a mover el cursor antes de la primera fila
        }
        return rowCount;
    }

    public RequestQueue getRequestQueue() throws SQLException
    {
        this.addQueryResultToQueue();
        return this.requestQueue;
    }
}
