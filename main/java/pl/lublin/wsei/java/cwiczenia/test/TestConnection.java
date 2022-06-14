package pl.lublin.wsei.java.cwiczenia.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;

public class TestConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String serverName = "localhost";
        String database = "mydb";
        Number portNumber = 3306;
        Connection conn = null;
        Properties conncectionProps = new Properties();
        conncectionProps.put("user", "root");
        conncectionProps.put("password", "zaq12345");
        conncectionProps.put("serverTimezone", "Europe/Warsaw");

        conn = DriverManager.getConnection(
                "jdbc:mysql://" + serverName + ":" + portNumber + "/" + database, conncectionProps
        );
        System.out.println("Connected to database");
    }
}