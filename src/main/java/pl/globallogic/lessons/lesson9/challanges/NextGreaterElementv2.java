package pl.globallogic.lessons.lesson9.challanges;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElementv2 {
    public static void main(String[] args) {
        ArrayList<Integer> bucket = bucketGenerator(1000);
        nextNumberGenerator(bucket);

    }

    private static void nextNumberGenerator(ArrayList<Integer> bucket) {
        Stack<Integer> stack = new Stack<>();
        for (int element : bucket) {
            while(!stack.isEmpty() && element > stack.peek()) {
                System.out.printf("The next number greater than %s is %s \n", stack.pop(), element);
            }
            stack.add(element);
        }

        while (!stack.isEmpty()) {
            System.out.printf("Number %s doesn't have greater number \n", stack.pop());
        }
    }

    private static ArrayList bucketGenerator(int range) {
        ArrayList<Integer> bucket = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            bucket.add((int) Math.floor(Math.random() * 100));
        }

        return bucket;
    }
}
