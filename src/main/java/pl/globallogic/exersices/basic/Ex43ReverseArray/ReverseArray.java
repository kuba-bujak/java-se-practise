package pl.globallogic.exersices.basic.Ex43ReverseArray;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArray {
    private static void reverse(int[] target) {
        for(int i = 0; i <= target.length / 2; i++) {
            int temp = target[i];
            target[i] = target[target.length - i - 1];
            target[target.length - i - 1] = temp;
        }
        System.out.printf("Reversed array: %s \n", Arrays.toString(target));
    }

    public static void main(String[] args) {
        int[] myArray = {10,20,2,49,1,-2,5};
        System.out.printf("Original array: %s \n", Arrays.toString(myArray));
        reverse(myArray);
    }
}
