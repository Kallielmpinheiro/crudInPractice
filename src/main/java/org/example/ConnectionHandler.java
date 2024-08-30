package org.example;
import java.sql.*;

public class ConnectionHandler {
    public Connection connectionDB(String dbname, String user, String pass) throws SQLException, ClassNotFoundException {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (con != null) {
                System.out.println("Conexão estabelecida com sucesso.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return con;
    }
}




