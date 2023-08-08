package pl.globallogic.exersices.basic;

public class Ex21AllFactors {
    public static void main(String[] args) {
        printFactors(6);
        printFactors(32);
        printFactors(10);
        printFactors(-1);
    }

    private static void printFactors(int number) {
        System.out.println("---------------------------");
        if (number < 1) System.out.println("Invalid Value");
        for(int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
    }
}
