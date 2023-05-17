public class Divider extends Calculator {

    int calculate(int value1, int value2) {
        int result = 0;

        try {
            result = value1 / value2;

        } catch (Exception e) {
            throw new ArithmeticException("Divided by zero!");

        }

        return result;
    }

}
