package pl.lublin.wsei.java.cwiczenia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
    public static void main(String[] args) throws SQLException {
        MyDB db = new MyDB("localhost", "mydb", 3306);
        db.setUser("root");
        db.setPassword("zaq12345");
        Connection conn = db.getConnection();
        if (conn != null) {
            Statement polecenie = conn.createStatement();
            ResultSet res = polecenie.executeQuery("SELECT * FROM COFFEE_HOUSES");
            System.out.printf("%10s%20s%7s%7s%7s\n", "STORE_ID", "CITY", "COFFEE", "MERCH", "TOTAL");
            while (res.next()) {
                System.out.printf("%10s%20s%7s%7s%7s/n", res.getInt(1), res.getString("CITY"), res.getInt(3), res.getInt(4), res.getInt(5));
            }
        }
        db.closeConnection();
        System.out.println("Polaczenie z baza zakonczone");
    }
}