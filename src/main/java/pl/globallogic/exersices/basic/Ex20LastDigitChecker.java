package pl.globallogic.exersices.basic;

public class Ex20LastDigitChecker {
    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(41, 22, 71));
        System.out.println(hasSameLastDigit(23, 32, 42));
        System.out.println(hasSameLastDigit(9, 99, 999));
        System.out.println("---------------------------");
        System.out.println(isValid(10));
        System.out.println(isValid(468));
        System.out.println(isValid(1051));

    }

    private static boolean hasSameLastDigit(int number1, int number2, int number3) {
        if (!isValid(number1) || !isValid(number2) || !isValid(number3)) return false;
        int digit1 = number1 % 10;
        int digit2 = number2 % 10;
        int digit3 = number3 % 10;
        if (digit1 == digit2 || digit1 == digit3 || digit2 == digit3) return true;
        return false;
    }

    private static boolean isValid(int number) {
        return number >= 10 && number <= 1000;
    }
}
