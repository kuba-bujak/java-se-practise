package pl.globallogic.exersices.basic;

public class Ex1PositiveNegativeZero {
    public static void main(String[] args) {
        checkNumber(10);
        checkNumber(-2);
        checkNumber(0);
    }

    private static void checkNumber(int number) {
        if (number < 0) {
            System.out.println("negative");
        } else if (number > 0) {
            System.out.println("positive");
        } else {
            System.out.println("zero");
        }
    }


}
