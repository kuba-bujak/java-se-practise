package pl.globallogic.lessons.lesson1;

public class PrimitiveTypesSandbox {
    public static void main(String[] args) {
        int number = 128;
        byte smallNumber = (byte)number;
        System.out.println(smallNumber);
        long bigNumber = 36712541;
        float floatNumber = 3.1457F;
        char symbol = 'd';
        boolean isJavaEasy = true;
        String firstName = "John Doe";
//        operations
        int sum = 23 + 567;
        int diff = 4567 - 41234;
        int idx = 1;
        int reminder = 10 % 4;
        System.out.println(reminder);
        System.out.println(idx--);
        System.out.println(--idx);
    }

}
