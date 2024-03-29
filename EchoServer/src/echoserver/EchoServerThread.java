/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

/**
 *
 * @author dzelazny
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
    
    //pętla główna
    while(true){
      try{
        line = brinp.readLine();

        System.out.println(threadName + "| Odczytano linię: " + line);

        //badanie warunku zakończenia pracy
        if((line == null) || "quit".equals(line)) {
          System.out.println(threadName + "| Zakończenie pracy z klientem: " + socket);
          socket.close();
          return;
        }

        if(line.charAt(0) == '1') {
          System.out.println("saldo----");

        }
        if(line.charAt(0) == '2') {
          System.out.println("wplata----");
          System.out.println(line.substring(2));
        }
        if(line.charAt(0) == '3') {
          System.out.println("wyplata----");
          System.out.println(line.substring(2));
        }


        //odesłanie danych do klienta
        out.writeBytes(line + "\n\r");
        System.out.println(threadName + "| Wysłano linię: " + line);

      }
      catch(IOException e){
        System.out.println(threadName + "| Błąd wejścia-wyjścia." + e);
        return;
      }
    }
  }
}


//else  { //odesłanie danych do klienta
//        out.writeBytes(line + "\n\r");
//        System.out.println(threadName + "| Wysłano linię: " + line);
//        }