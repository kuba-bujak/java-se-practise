package pl.globallogic.exersices.basic.Ex42MinimumElement;

import java.util.Scanner;

public class MinimumElement {
    private static int readIntegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements do you want to add? ");
        return scanner.nextInt();
    }

    private static int[] readElements(int range) {
        int[] array = new int[range];
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Add %s elements \n", range);
        for (int i = 0; i < range; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int findMin(int[] target) {
        int minNum = target[0];
        for (int element : target) {
            if (element < minNum) minNum = element;
        }
        return minNum;
    }

    public static void main(String[] args) {
        int range = readIntegers();
        int[] myArray = readElements(range);
        System.out.printf("The lowest value inserted into array is: %s", findMin(myArray));
    }

}
