package client;

import java.util.Objects;

public class Admin {

    public static String menu() {
        System.out.println("1 - Lista uzytkownikow");

        String operationNumber = "";
        String value = "";


        String line = reader.readLine();

        if(line == null) return "quit";
        if(Objects.equals(line, "0")) return "quit";

        System.out.println("0 - Zakonczyc");

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


        return "";
    }
    private static String userList() {
        return "5";
    }

}
