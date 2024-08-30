package org.example;

import java.sql.*;

public class dbfunctions {

    public void createTable(String tableName){
        Statement stmt;
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String query = "CREATE TABLE IF NOT EXISTS "+tableName+
                "(empid SERIAL, name varchar(255),address varchar(255), primary key(empid));";
        stmt = connection.createStatement();
        stmt.executeUpdate(query);
        System.out.println("Table criado com sucesso");
        }catch (Exception e){

        }
    }
    public void insertRow(String name, String address,String tableName){
        Statement stmt;
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String query = String.format("INSERT INTO %s(name, address) VALUES('%s', '%s');", tableName, name, address);
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table inserido com sucesso");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void readData(String tableName){
        Statement stmt;
        ResultSet rs = null;
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String query=String.format("SELECT * FROM  %s" , tableName);
            stmt = connection.createStatement();
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
    public void updateName(String tableName, String Oldname, String newName){
        Statement stmt;
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String query= String.format("update %s set name = '%s' where name = '%s'", tableName, newName, Oldname);
           stmt = connection.createStatement();
           stmt.executeUpdate(query);
           System.out.println("Nome atualizado com sucesso");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void searchByName(String tableName, String name){
        Statement stmt;
        ResultSet rs = null;
        try{
            Connection connection = ConnectionManager.getInstance().getConnection();
            String query = String.format("SELECT * FROM  %s where name = '%s'" , tableName,name);
            stmt = connection.createStatement();
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
    public void deleteByName(String tableName, String name){
        Statement stmt;
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            String query = String.format("DELETE FROM  %s where name = '%s'" , tableName,name);
          stmt = connection.createStatement();
          stmt.executeUpdate(query);
          readData(tableName);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
