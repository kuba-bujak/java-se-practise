package pl.globallogic.recursion;

public class FibonacciExample {

    // generate fibonacci(n)
    public static void main(String[] args) {
        int number = 8;
        System.out.println(fibonacciRecursive(number));
        System.out.println(fibonacciIterative(number));
    }

    private static int fibonacciIterative(int number) {
        int last = 0, next = 1;
        for (int i = 0; i < number; i++) {
            int oldLast = last;
            last = next;
            next = oldLast + next;
        }
        return last;
    }

    private static int fibonacciRecursive(int number) {
        if (number < 2) {
            return number;
        }
        return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
    }
}
