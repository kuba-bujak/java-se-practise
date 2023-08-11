package pl.globallogic.exersices.basic.Ex22GreatestCommonDivisor;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(getGreatestDivisior(25, 15));
        System.out.println(getGreatestDivisior(12, 30));
        System.out.println(getGreatestDivisior(9, 18));
        System.out.println(getGreatestDivisior(81, 153));
    }

    private static int getGreatestDivisior(int first, int second) {
        if (first < 10 || second < 10) return -1;
        int result = 0;
        if (first < second) {
            for (int i = 1; i <= second; i++) {
                if (first % i == 0 && second % i == 0) result = i;
            }
        } else {
            for (int i = 1; i <= first; i++) {
                if (first % i == 0 && second % i == 0) result = i;
            }
        }
        return result;
    }
}
