package org.example;

public class Main {
    public static void main(String[] args) {
    ConnectionManager connectionManager = ConnectionManager.getInstance();
    ConnectionManager.initialize("Users", "postgres", "123");
    dbfunctions dbfunctions = new dbfunctions();
    dbfunctions.readData("teste");
    dbfunctions.updateName("teste","Kalliel","Kalliel22" );
    dbfunctions.searchByName("teste", "Kalliel");
    dbfunctions.readData("teste");
    dbfunctions.deleteByName("teste","Kalliel22");
    dbfunctions.createTable("teste");
    dbfunctions.insertRow("Kalliel","brasil","teste");
    }
}