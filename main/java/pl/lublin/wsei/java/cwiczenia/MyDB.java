package pl.lublin.wsei.java.cwiczenia;

import java.sql.*;
import java.util.Properties;

public class MyDB {
    private final String serverName;
    private final String database;
    private final Number portNumber;
    private String user;
    private String password;

    private Connection conn = null;
    private Statement statement = null;;

    public MyDB(String serverName, String database, Number portNumber) {
        this.serverName = serverName;
        this.database = database;
        this.portNumber = portNumber;
    }

    public ResultSet selectData(String selectStatement) {
        if((conn != null) && (statement != null))
            try {
                return statement.executeQuery(selectStatement);
            } catch (SQLException e) {
                System.out.println("Blad realizacji zapytania: " + selectStatement + ", " + e.getMessage());
            }
        return null;
    }
    private void connect() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", user);
        connectionProps.put("password", password);
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        String jdbcString = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + database;
        try {
            conn = DriverManager.getConnection(
                    jdbcString, connectionProps
            );
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Blad podlaczenia do bazy: " + jdbcString);
            System.out.println("Komunikat bledu: " + e.getMessage());
        }
        System.out.println("Connected to database" + database);
    }

    public Connection getConnection() {
        if (conn == null)
            connect();
        return conn;

    }
    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Blad przy zamykaniu polaczenia bazodanowego " + e.getMessage());
            }
            conn = null;
        }
    }
}