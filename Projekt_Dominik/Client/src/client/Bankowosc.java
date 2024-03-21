package client;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;


public class Bankowosc {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String menu() throws IOException {

        System.out.println("1 - Stan konta");
        System.out.println("2 - Wplata srodkow");
        System.out.println("3 - Wyplata srodkow");
        System.out.println("4 - Przelew");
        System.out.println("5 - Wylogowac sie");
        System.out.println("0 - Zakonczyc");

        String operationNumber = "";
        String value = "";


        String line = reader.readLine();

        if(line == null) return "quit";
        if(Objects.equals(line, "0")) return "quit";

        operationNumber = switch (line) {
            case "1" -> {
                value = stanKonta();
                yield String.valueOf(line);
            }
            case "2" -> {
                value = wplata();
                yield String.valueOf(line);
            }
            case "3" -> {
                value = wyplata();
                yield String.valueOf(line);
            }
            case "4" -> {
                value = przelew();
                yield String.valueOf(line);
            }
            default -> operationNumber;
        };
        return operationNumber + " " + value;
    }

    private String przelew() throws IOException {
        System.out.println("Komu wyslac: ");
        String reciver = reader.readLine();
        System.out.println("Kwota dla wplaty: ");
        String amount = reader.readLine();
        return reciver + " " + amount;
    }

    private String wplata() throws IOException {
        System.out.println("Kwota dla wplaty: ");

        return reader.readLine();
    }

    private String wyplata() throws IOException {
        System.out.println("Kwota dla wyplaty: ");

        return reader.readLine();
    }

    private String stanKonta() {
        return "";
    }

}
