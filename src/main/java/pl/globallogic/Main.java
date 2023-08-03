package pl.globallogic;

public class Main {
    public static void main(String[] args) {
        int number = 67;
        System.out.println("This is my number - " + checkNumber(number));
        System.out.println("Hello world!");
    }

    static String checkNumber(int arg) {
        return  arg + " is checked";
    }
}