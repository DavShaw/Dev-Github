package org.davshaw.external;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public  class DataBase
{

    private Connection connection;
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;

    public DataBase(String host, int port, String database, String username, String password)
    {
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
        this.connect();
    }

    public void connect()
    {
        try
        {
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
            this.connection = DriverManager.getConnection(url, username, password);
        }
        
        catch (SQLException error)
        {
            throw new RuntimeException("Error al establecer la conexión a la base de datos", error);
        } 
    }

    public void disconnect()
    {
        try
        {
            if (connection != null && !connection.isClosed())
            {
                connection.close();
            }
        }
        
        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    public Integer executeUpdate( String sql)
    {
        try ( Statement statement = connection.createStatement())
        {
            return statement.executeUpdate(sql);
        }

        catch (SQLException error) 
        {
            System.err.println("Error al ejecutar la consulta: " + error.getMessage());
            return null;
        }

    }

    public int[] executeBatchUpdate(List<String> sqlStatements) {
        try ( Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false); // Desactivar la confirmación automática para habilitar el lote
    
            for (String sql : sqlStatements) {
                statement.addBatch(sql); // Agregar cada consulta al lote
            }
    
            int[] updateCounts = statement.executeBatch(); // Ejecutar todas las consultas en el lote
    
            connection.commit(); // Confirmar los cambios en el lote
            return updateCounts; // Devolver un arreglo con los resultados de las actualizaciones
        } catch (SQLException error) {
            try {
                connection.rollback(); // Revertir los cambios en caso de error
            } catch (SQLException rollbackError) {
                rollbackError.printStackTrace();
            }
            error.printStackTrace();
            return null;
        } finally {
            try {
                connection.setAutoCommit(true); // Volver a activar la confirmación automática
            } catch (SQLException autoCommitError) {
                autoCommitError.printStackTrace();
            }
        }
    }
    


    public ResultSet executeQuery(String sql) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }
    
}
