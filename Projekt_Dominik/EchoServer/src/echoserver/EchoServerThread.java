/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

/**
 *
 * @author holias
 */
import java.net.*;
import java.io.*;

public class EchoServerThread implements Runnable
{

  protected Socket socket;
  public EchoServerThread(Socket clientSocket)
  {
    this.socket = clientSocket;
  }
  public void run()
  {
    //Deklaracje zmiennych
    BufferedReader brinp = null;
    DataOutputStream out = null;
    String threadName = Thread.currentThread().getName();
    
    //inicjalizacja strumieni
    try{
      brinp = new BufferedReader(
        new InputStreamReader(
          socket.getInputStream()
        )
      );
      out = new DataOutputStream(socket.getOutputStream());
    }
    catch(IOException e){
      System.out.println(threadName + "| Błąd przy tworzeniu strumieni " + e);
      return;
    }
    String line = null;
    String login = "";
    //pętla główna
    while(true){

      try{
        line = brinp.readLine();
        System.out.println(threadName + "| Odczytano linię: " + line);
        boolean isAdmin = false;
        //badanie warunku zakończenia pracy
        if((line == null) || "quit".equals(line)) {
          System.out.println(threadName + "| Zakończenie pracy z klientem: " + socket);
          socket.close();
          return;
        } else  { //odesłanie danych do klienta
          String toSend = "";
          String[] loginData = line.split(" ");
          int loginStatus = 0;
          if(line.charAt(0) == 'l') {
            loginStatus = auth.login(loginData[1], loginData[2]);
            System.out.println(loginStatus);
            if(loginStatus == 1) {
              login = loginData[1];
              toSend = "1";
            } else if (loginStatus == 2) {
              isAdmin = true;
              login = loginData[1];
              toSend = "2";
            } else  {
              toSend = "0";
            }
          }  else if(line.charAt(0) == '1') { // stan konta
            String amount = auth.saldo(login);
            toSend = "Stan konta = " + amount + " zl.";
          } else if(line.charAt(0) == '2') { // wplata
            auth.wplata(login, Integer.valueOf(line.substring(2)));
            toSend ="Success!";
          } else if(line.charAt(0) == '3') { //wyplata
            auth.wyplata(login, Integer.valueOf(line.substring(2)));
            toSend = "Success!";
          } else if(line.charAt(0) == '4') { //wyplata
            int status = auth.przelew(login,  loginData[1], Integer.valueOf(loginData[2]));
            if(status == 2) {
              toSend = "Podane konto nie istnee!";
            } else if(status == 1) {
              toSend ="Success!";
            } else if (status == 3) {
              toSend = "Niepoprawna kwota!";
            }

          }

          System.out.println(threadName + "| Wysłano linię: " + toSend);
          out.writeBytes(toSend + "\r");
        }
      }
      catch(IOException e){
        System.out.println(threadName + "| Błąd wejścia-wyjścia." + e);
        return;
      }
    }
  }
}


