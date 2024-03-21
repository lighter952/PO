package echoserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class auth {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public static int login(String login, String pass) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM userss WHERE login = \"" + login + "\";");
            String passBD = rs.getString("password");

            ResultSet rss = stmt.executeQuery("SELECT * FROM userss WHERE login = \"" + login + "\";");
            int isAdmin = Integer.valueOf(rss.getString("isAdmin"));
            conn.close();
            if(isAdmin == 1 && pass.equals(passBD)){
                return 2;
            } else if (pass.equals(passBD)) {
                return 1;
            }   else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


//    public static void signup(String login, String pass){
//
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db");
//            Statement stmt = conn.createStatement();
//
//            stmt.executeUpdate("INSERT INTO users VALUES(\"" + login + "\",\"" + pass + "\");");System.out.println("Account created!");
//
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static String saldo(String login) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM userss WHERE login = \"" + login + "\";");
            String amount = rs.getString("amount");

            conn.close();
            return amount;
        }   catch (Exception e) {

            e.printStackTrace();
            return "";
        }
    }

    public static void wplata(String login, Integer value){
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE userss SET amount = amount + " + value + " WHERE login = \""+ login +"\";\n");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void wyplata(String login, Integer value){
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE userss SET amount = amount - " + value + " WHERE login = \""+ login +"\";\n");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int przelew(String loginFrom, String loginTo, Integer value) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:users.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM userss WHERE login = \"" + loginTo + "\";");
            String amount = rs.getString("amount");

            if(amount == null) {
                return 2;
            }

            if(value <= 0) {
                return 3;
            }
            stmt.executeUpdate("UPDATE userss SET amount = amount - " + value + " WHERE login = \""+ loginFrom +"\";\n");
            stmt.executeUpdate("UPDATE userss SET amount = amount + " + value + " WHERE login = \""+ loginTo +"\";\n");


            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

}
