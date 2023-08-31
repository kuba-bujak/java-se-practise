package pl.globallogic.exersices.basic.Ex41SortedArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        int[] array = getIntegers();
        System.out.printf("Your array: %s \n", Arrays.toString(array));
        int[] sortedArray = sortIntegers(array);
        printArray(sortedArray);


    }

    private static void printArray(int[] sortedArray) {
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.printf("Element %s contents %s \n", i, sortedArray[i]);
        }
    }

    private static int[] sortIntegers(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    private static int[] getIntegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements you want to store ");
        int number = scanner.nextInt();
        int[] array = new int[number];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
}
