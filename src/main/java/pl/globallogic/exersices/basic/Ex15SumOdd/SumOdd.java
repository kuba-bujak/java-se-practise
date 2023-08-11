package pl.globallogic.exersices.basic.Ex15SumOdd;

public class SumOdd {
    public static void main(String[] args) {
        System.out.println(isOdd(1));
        System.out.println(isOdd(-1));
        System.out.println(isOdd(100));
        System.out.println(isOdd(13));
        System.out.println(isOdd(100));
        System.out.println(isOdd(100));
        System.out.println("-------------------");
        System.out.println(sumOdd(1, 100));
        System.out.println(sumOdd(-1, 100));
        System.out.println(sumOdd(100, 100));
        System.out.println(sumOdd(13, 13));
        System.out.println(sumOdd(100, -100));
        System.out.println(sumOdd(100, 1000));
    }

    private static int sumOdd(int start, int end) {
        int result = 0;
        if (start <= 0 || end <= 0 || end < start) return -1;
        for (int i = start; i <= end; i++) {
            if(isOdd(i)) {
                result += i;
            }
        }
        return result;
    }

    private static boolean isOdd(int number) {
        if (number <= 0) return false;
        return number % 2 != 0;
    }
}
