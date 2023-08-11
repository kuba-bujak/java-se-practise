package pl.globallogic.exersices.basic.OtherProjects;

import java.util.ArrayList;
import java.util.Arrays;

public class CandyShop {
    public static void main(String[] args) {
        int[] candies = {3,4,1,2,5,3,5,7,10};
        int money = 30;
        sort(candies);
        System.out.printf("Sorted candy prices: %s \n", Arrays.toString(candies));
        System.out.printf("Number of candies which can be bought for $ %s : %s \n", money, findNumberOfCandies(candies, money));
    }

    private static void sort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static ArrayList<Integer>findNumberOfCandies(int[] candy, int money) {
        ArrayList<Integer>result = new ArrayList<>();
        int priceForCandies = 0;
        for (int price : candy) {
            if (price + priceForCandies <= money) {
                priceForCandies += price;
                result.add(price);
            }
        }
        return result;
    }
}
