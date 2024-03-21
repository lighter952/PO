package echoserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class db {

    public static void aa()  {

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db");
            Statement stmt = conn.createStatement();

            //stmt.executeUpdate("ALTER TABLE userss ADD COLUMN isAdmin INTEGER DEFAULT 0;");
            stmt.executeUpdate("UPDATE userss SET isAdmin = 1 WHERE login =\"holias\";");

            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
