package pl.globallogic.exersices.basic;

public class Ex10MinutesToYearsAndDaysCalculator {
    public static void main(String[] args) {
        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);
    }

    private static void printYearsAndDays(long minutes) {
        if (minutes < 0) System.out.println("Invalid Value");
        long hours = minutes / 60;
        long days = hours / 24;
        long years = days / 365;

        days = days % 365;
        System.out.println("" + minutes + " min = " + years + " y and " + days + " d");


    }
}
