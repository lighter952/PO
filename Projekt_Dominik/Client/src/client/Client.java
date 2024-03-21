package client;

/**
 *
 * @author dzelazny
 */
import java.net.*;
import java.io.*;
import java.util.Objects;


public class Client {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String args[]) throws IOException {
        String host = "localhost";
        int port = 0;
        Bankowosc bankowosc = new Bankowosc();
        try {
            port = new Integer("6666").intValue();
        } catch (NumberFormatException e) {
            System.out.println("Nieprawidłowy argument: port");
            System.exit(-1);
        }
        //Inicjalizacja gniazda klienckiego
        Socket clientSocket = null;
        try {
            clientSocket = new Socket(host, port);
        } catch (UnknownHostException e) {
            System.out.println("Nieznany host.");
            System.exit(-1);
        } catch (ConnectException e) {
            System.out.println("Połączenie odrzucone.");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Błąd wejścia-wyjścia: " + e);
            System.exit(-1);
        }
        System.out.println("Połączono z " + clientSocket);


        //Deklaracje zmiennych strumieniowych 
        String line = null;
        BufferedReader brSockInp = null;
        BufferedReader brLocalInp = null;
        DataOutputStream out = null;

        try {
            out = new DataOutputStream(clientSocket.getOutputStream());
            brSockInp = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            brLocalInp = new BufferedReader(
                    new InputStreamReader(System.in));
        } catch (IOException e) {
            System.out.println("Błąd przy tworzeniu strumieni: " + e);
            System.exit(-1);
        }
        boolean isAdmin = false;
        boolean isLogged = false;
        //Pętla główna klienta
        while (true) {

            try {

                if (isLogged == false) {
                    String toSend = Users.login();
                    out.writeBytes(toSend + '\r');
                    out.flush();
                    line = brSockInp.readLine();


                    if (line.equals("1")) {
                        isLogged = true;
                        System.out.println("Login soccess!");
                    }  else if(line.equals("2")) {
                        isLogged = true;
                        isAdmin = true;
                        System.out.println("ADMIN!");
                    } else  {
                        System.out.println("Incorrect username or password!");
                        continue;
                    }
                }

                String toSend = "";
                if(isAdmin) {
                    toSend = Admin.menu();
                } else {
                    toSend = bankowosc.menu();
                }

                if (toSend == null || "quit".equals(toSend)) {
                    System.out.println("Kończenie pracy...");
                    clientSocket.close();
                    System.exit(0);
                }

                out.writeBytes(toSend + '\r');
                out.flush();

                line = null;
                while(line == null) {
                    line = brSockInp.readLine();
                }

                System.out.println(line);

            } catch (IOException e) {
                System.out.println("Błąd wejścia-wyjścia: " + e);
                System.exit(-1);
            }
        }
    }
}
