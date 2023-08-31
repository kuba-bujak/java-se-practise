package pl.globallogic.lessons.lesson9.challanges;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] input = {1,3,4,2,5,3,2,10,5,11};
        findNextGreaterElementFor(input);
    }

    private static void findNextGreaterElementFor(int[] input) {
        Stack<Integer> stack = new Stack<>();

        for (int element : input) {
            while (!stack.isEmpty() && element > stack.peek()) {
                System.out.printf("For %s next greater is %s \n", stack.pop(), element);
            }
            stack.add(element);
        }

        while(!stack.isEmpty()) {
            System.out.printf("For %s next greater is -1 \n", stack.pop());
        }
    }
}
