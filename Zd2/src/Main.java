
public class Main {
    public static void main(String[] args) {
        Adder add = new Adder();
        Subtractor sub = new Subtractor();
        Multiplier mul = new Multiplier();
        Divider div = new Divider();

        System.out.println(add.calculate(2,2));
        System.out.println(sub.calculate(2,2));
        System.out.println(mul.calculate(2,2));
        System.out.println(div.calculate(2,4));

    }
}

