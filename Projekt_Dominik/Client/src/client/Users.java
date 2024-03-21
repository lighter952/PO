package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Users {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String login() throws IOException {
        System.out.println("Login: ");
        String login = reader.readLine();
        System.out.println("Password: ");
        String pass = reader.readLine();

        return "l" + " " + login + " " + pass;
    }

    public static String signup() throws IOException {

        System.out.println("Login: ");
        String login = reader.readLine();
        System.out.println("Password: ");
        String pass = reader.readLine();

        return "s" + " " + login + " " + pass;
    }
}
