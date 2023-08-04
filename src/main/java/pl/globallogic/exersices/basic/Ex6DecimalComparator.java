package pl.globallogic.exersices.basic;

public class Ex6DecimalComparator {
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175));
        System.out.println(areEqualByThreeDecimalPlaces(3.175, 3.176));
        System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0));
        System.out.println(areEqualByThreeDecimalPlaces(-3.123, 3.123));
    }

    private static boolean areEqualByThreeDecimalPlaces(double number1, double number2) {
        int scaledNum1 = (int) (number1 * 1000);
        int scaledNum2 = (int) (number2 * 1000);
        System.out.println(scaledNum1 + " " + scaledNum2);

        return scaledNum1 == scaledNum2;
    }
}
