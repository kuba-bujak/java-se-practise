package pl.globallogic.exersices.basic.Ex23PerfectNumber;

public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));
    }

    private static boolean isPerfectNumber(int number) {
        if (number < 1) return false;
        int result = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) result += i;
        }
        return result == number;
    }
}
