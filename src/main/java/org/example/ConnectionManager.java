package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {

    private static ConnectionManager instance;

    private static Connection connection;

    private ConnectionManager() {}

    public static ConnectionManager getInstance() {
        if (instance == null) {
            synchronized (ConnectionManager.class) {
                if (instance == null) {
                    instance = new ConnectionManager();
                }
            }
        }
        return instance;
    }

    public static void initialize(String dbname, String user, String pass) {
        if (connection == null) {
            try {
                ConnectionHandler handler = new ConnectionHandler();
                connection = handler.connectionDB(dbname, user, pass);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Falha ao inicializar a conexão com o banco de dados.", e);
            }
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            throw new IllegalStateException("ConnectionManager não foi inicializado. Chame initialize() primeiro.");
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection = null;
            }
        }
    }
}
