package org.example;

public class Main {
    public static void main(String[] args) {
    dbfunctions dbfunctions = new dbfunctions();
    dbfunctions.connectionDB("Users","postgres","123");
    //dbfunctions.readData(dbfunctions.connectionDB("Users","postgres","123"),"teste");
    //dbfunctions.updateName(dbfunctions.connectionDB("Users","postgres","123"),"teste","Kalliel","Kalliel22" );
    //dbfunctions.searchByName(dbfunctions.connectionDB("Users","postgres","123"),"teste", "Kalliel");
    //dbfunctions.readData(dbfunctions.connectionDB("Users","postgres","123"),"teste");
    dbfunctions.deleteByName(dbfunctions.connectionDB("Users","postgres","123"),"teste","Kalliel22");
    dbfunctions.createTable(dbfunctions.connectionDB("Users","postgres","123"), "teste");
    dbfunctions.insertRow(dbfunctions.connectionDB("Users","postgres","123"), "Kalliel","brasil","teste");

    }
}