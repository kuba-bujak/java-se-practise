package pl.globallogic.exersices.basic.Ex16NumberPalindrome;

public class NumberPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));
    }

    private static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reversedNumber = 0;

        while (number != 0){
            int lastNumber = number % 10;
            reversedNumber = reversedNumber * 10 + lastNumber;
            number /= 10;
        }

        return originalNumber == reversedNumber;
    }
}
