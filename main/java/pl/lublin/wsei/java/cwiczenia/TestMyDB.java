package pl.lublin.wsei.java.cwiczenia;

import java.sql.Connection;

public class TestMyDB {
    public static void main(String[] args) {
        MyDB db = new MyDB("localhost", "mydb", 3306);
        db.setUser("root");
        db.setPassword("zaq12345");
        Connection conn = db.getConnection();
        if(conn != null)
            System.out.println("Polaczenie z baza danych nawiazane");

        db.closeConnection();
        System.out.println("Polaczenie z baza zakonczone");

    }

}