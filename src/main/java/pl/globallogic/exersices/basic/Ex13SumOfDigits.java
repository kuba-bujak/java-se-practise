package pl.globallogic.exersices.basic;

import java.util.Scanner;

public class Ex13SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please pass a number: ");
        int number = scanner.nextInt();

        System.out.println(number);
        System.out.println(sumOfDigits(number));
    }

    public static int sumOfDigits(int number) {
        int temp = 0;
        int result = 0;
        if (number < 0) {
            temp = -number;
        } else {
            temp = number;
        }
        if (temp == 0) return 0;
        while (temp > 0) {
            result += temp % 10;
            temp /= 10;
        }
        return result;
    }
}
