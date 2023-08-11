package pl.globallogic.exersices.basic.OtherProjects;

import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to count it's digits:");
        int number = scanner.nextInt();
        System.out.println("Digit count for " + number + " is: " + numberOfDigits(number));
//        System.out.println(numberOfDigits(13456) == 5);
//        System.out.println(numberOfDigits(87254637) == 8);
//        System.out.println(numberOfDigits(-3749261) == -1);
    }

    private static int numberOfDigits(int number) {
        if (number < 0)
            return -1;
        int counter = 0;
        while (number > 0) {
            number = number / 10;
            counter++;
        }
        return counter;
    }
}
