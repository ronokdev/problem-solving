package com.ronok.algoexpert;


import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args){
        System.out.println(Arrays.toString(doInsertionSort(new int[]{8,5,2,9,5,6,3})));
        System.out.println(Arrays.toString(doInsertionSort(new int[]{3, 66, 1, 555, 909, -9, 5})));
    }

    private static int[] doInsertionSort(int[] arr) {
        /*
         * in insertion sort we will always think that the 0th index (First element) is always sorted
         *
         * Steps:
         *  write a FOR loop for iterating through the arr
         *  we will call this iterating "passes"
         *
         *  the for loop will start from 1 index of the arr
         *   we will get the value(v) a specific index and
         *  check which value is smaller than v
         *  we will do this checking via a WHILE loop
         *
         * Time complexity  : O(n^2)
         * Space complexity : O(1)
         * */


        int el = 0;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {

            el = arr[i];
            j = i - 1;

            // Here we are in need of the j > -1 logic because, we are decrementing j and some point it will be '-1'
            while (j > -1 && el < arr[j]) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = el;
        }
        return arr;
    }
}
