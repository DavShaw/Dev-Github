package supportclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;
    private Connection connection;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void connect() {
        if (host != null && !host.isEmpty() && port > 0 && database != null && !database.isEmpty() && username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            String connectionString = "jdbc:mysql://" + host + ":" + port + "/" + database + "?user=" + username + "&password=" + password;

            try {
                this.connection = DriverManager.getConnection(connectionString);
                System.out.println("Conexión exitosa a la base de datos");
            } catch (SQLException e) {
                System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        } else {
            System.out.println("No se puede conectar debido a que faltan credenciales.");
        }
    }

    public void disconnect() {
        try {
            if (this.connection != null) {
                this.connection.close();
                System.out.println("Conexión cerrada");
            }
        } catch (Exception e) {
            System.err.println("Error al desconectar de la base de datos: " + e.getMessage());
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;

        try {
            if (connection != null && !connection.isClosed()) {
                Statement statement = this.connection.createStatement();
                resultSet = statement.executeQuery(sql);
            } else {
                System.out.println("No se puede ejecutar la consulta porque la conexión está cerrada o no está establecida.");
            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }

        return resultSet;
    }
}
