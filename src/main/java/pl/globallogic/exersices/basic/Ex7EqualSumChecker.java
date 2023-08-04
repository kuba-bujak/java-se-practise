package pl.globallogic.exersices.basic;

public class Ex7EqualSumChecker {
    public static void main(String[] args) {
        System.out.println(hasEqualSum(1, 1, 1));
        System.out.println(hasEqualSum(1, 1, 2));
        System.out.println(hasEqualSum(1, -1, 0));
    }

    private static boolean hasEqualSum(int number1, int number2, int number3) {
        if (number1 + number2 == number3) return true;
        return false;
    }
}
