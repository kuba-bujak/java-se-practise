package pl.globallogic.exersices.basic;

public class Ex18EvenDigitSum {
    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789));
        System.out.println(getEvenDigitSum(252));
        System.out.println(getEvenDigitSum(-22));
    }

    private static int getEvenDigitSum(int number) {
        if (number < 0) return -1;
        int sum = 0;
        while (number > 0) {
            int currentNumber = number % 10;
            if (currentNumber % 2 == 0) sum += currentNumber;
            number /= 10;
        }
        return sum;
    }
}
