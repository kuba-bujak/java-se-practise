package pl.globallogic.exersices.basic.OtherProjects;

public class PrimeNumbers {
    public static void main(String[] args) {
        int number = 17;
        System.out.printf("Prime numbers before '%s': \n", number);
        isPrimeNumber(number);
    }

    private static void isPrimeNumber(int candidate) {

        for (int i = 2; i < candidate; i++) {
            if (isPrime(i)){
                System.out.println(i + " ");
            }
        }
    }

    private static boolean isPrime(int candidate) {
        for (int i = 2; i <= Math.sqrt(candidate); i++) {
            if (candidate % i == 0) return false;
        }
        return true;
    }
}
