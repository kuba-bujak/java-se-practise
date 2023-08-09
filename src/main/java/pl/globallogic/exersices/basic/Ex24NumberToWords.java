package pl.globallogic.exersices.basic;

public class Ex24NumberToWords {
    public static void main(String[] args) {
        System.out.println(getDigitCount(0));
        System.out.println(getDigitCount(123));
        System.out.println(getDigitCount(-12));
        System.out.println(getDigitCount(5200));
        System.out.println("--------------------------");
        System.out.println(reverse(-121));
        System.out.println(reverse(1212));
        System.out.println(reverse(1234));
        System.out.println(reverse(100));
        System.out.println("--------------------------");
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(1010));
        System.out.println(numberToWords(1000));
        System.out.println(numberToWords(-12));

    }

    private static int getDigitCount(int number) {
        if (number < 0) return -1;
        if (number == 0) return 1;
        int numberOfDigits = 0;
        while (number > 0) {
            numberOfDigits++;
            number /= 10;
        }
        return numberOfDigits;
    }

    private static int reverse(int number) {
        int reversed = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            reversed = reversed * 10 + lastDigit;
            number /= 10;
        }
        return reversed;
    }

    private static String numberToWords(int number) {
        if (number < 0) return "Invalid Value";
        int reversedNumber = reverse(number);
        int originalNumberDigits = getDigitCount(number);
        int reverseNumberDigits = getDigitCount(reversedNumber);
        StringBuilder result = new StringBuilder();
        while(reversedNumber != 0) {
            int lastDigit = reversedNumber % 10;
            switch(lastDigit) {
                case 0 ->  result.append("Zero ");
                case 1 ->  result.append("One ");
                case 2 ->  result.append("Two ");
                case 3 ->  result.append("Three ");
                case 4 ->  result.append("Four ");
                case 5 ->  result.append("Five ");
                case 6 ->  result.append("Six ");
                case 7 ->  result.append("Seven ");
                case 8 ->  result.append("Eight ");
                case 9 ->  result.append("Nine ");
                default -> System.out.println("Invalid Value");
            }
            reversedNumber /= 10;
        }
        result.append("Zero ".repeat(Math.max(0, originalNumberDigits - reverseNumberDigits)));
        return result.toString();
    }
}
