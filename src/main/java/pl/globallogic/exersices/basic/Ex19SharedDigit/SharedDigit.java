package pl.globallogic.exersices.basic.Ex19SharedDigit;

public class SharedDigit {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 23));
        System.out.println(hasSharedDigit(9, 99));
        System.out.println(hasSharedDigit(15, 55));
        System.out.println(hasSharedDigit(14, 55));
    }

    private static boolean hasSharedDigit(int number1, int number2) {
        if (isValid(number1) || isValid(number2)) return false;
        int digit1 = number1 / 10;
        int digit2 = number1 % 10;
        int digit3 = number2 / 10;
        int digit4 = number2 % 10;
        return digit1 == digit3 || digit1 == digit4 || digit2 == digit3 || digit2 == digit4;
    }

    private static boolean isValid(int num) {
        return num < 10 || num > 99;
    }
}
