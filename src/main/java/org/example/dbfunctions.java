package org.example;

import java.sql.*;

public class dbfunctions {
    public Connection connectionDB(String dbname,String user,String pass) {
        Connection con = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if (con!=null){
                System.out.println("Conexao estabelecida com sucesso");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
    public void createTable(Connection conn,String tableName){
        Statement stmt;
        try {
        String query = "CREATE TABLE IF NOT EXISTS "+tableName+
                "(empid SERIAL, name varchar(255),address varchar(255), primary key(empid));";
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        System.out.println("Table criado com sucesso");
        }catch (Exception e){

        }
    }
    public void insertRow(Connection conn, String name, String address,String tableName){
        Statement stmt;
        try {
            String query = String.format("INSERT INTO %s(name, address) VALUES('%s', '%s');", tableName, name, address);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table inserido com sucesso");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void readData(Connection conn, String tableName){
        Statement stmt;
        ResultSet rs = null;
        try {
            String query=String.format("SELECT * FROM  %s" , tableName);
            stmt = conn.createStatement();
            rs= stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString("empid")+" ");
                System.out.println(rs.getString("name")+ " ");
                System.out.println(rs.getString("address")+ " ");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void updateName(Connection conn, String tableName, String Oldname, String newName){
        Statement stmt;
        try {
           String query= String.format("update %s set name = '%s' where name = '%s'", tableName, newName, Oldname);
           stmt = conn.createStatement();
           stmt.executeUpdate(query);
           System.out.println("Nome atualizado com sucesso");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void searchByName(Connection conn, String tableName, String name){
        Statement stmt;
        ResultSet rs = null;
        try{
            String query = String.format("SELECT * FROM  %s where name = '%s'" , tableName,name);
            stmt = conn.createStatement();
            stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString("empid")+" ");
                System.out.println(rs.getString("name")+ " ");
                System.out.println(rs.getString("address")+ " ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void deleteByName(Connection conn, String tableName, String name){
        Statement stmt;
        try {
          String query = String.format("DELETE FROM  %s where name = '%s'" , tableName,name);
          stmt = conn.createStatement();
          stmt.executeUpdate(query);
          readData(connectionDB("Users","postgres","123"),"teste");
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
