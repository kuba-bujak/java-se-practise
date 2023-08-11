package pl.globallogic.exersices.basic.OtherProjects;

import java.util.Scanner;

public class PowerOfNumberCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println("Enter target power: ");
        int power = scanner.nextInt();
        System.out.println("Your number " + number + " powered by " + power + " is equal to: " + calculatePower(number, power));
    }

    private static int calculatePower(int number, int power) {
        if (power < 0) return 0;
        if (power == 0) return 1;
        int result = 1;
        for (int i = 1; i < power; i++) {
            result *= number;
        }
        return result;
    }
}
