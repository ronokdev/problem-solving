package com.ronok.algoexpert;


import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args){
        System.out.println(Arrays.toString(doInsertionSort(new int[]{6,8,12,14,18,20,9})));
        System.out.println(Arrays.toString(doInsertionSort(new int[]{8,5,2,9,5,6,3})));
        System.out.println(Arrays.toString(doInsertionSort(new int[]{3, 66, 1, 555, 909, -9, 5})));
    }

    private static int[] doInsertionSort(int[] arr) {
        /*
         * in insertion sort we will always think that the 0th index (First element) is always sorted
         *
         * Scenario:
         *  Lets imagine we have an array like this: `6,8,12,14,18,20,9` and
         *  in the array first 6th element is SORTED but the 7th element is not sorted and
         *
         *  we want to insert `9` at a SORTED position to the Array
         *
         *  So for insertion sort the process is going to be like below
         *
         *      - we will pick 9 from the array and save it to a variable
         *      - then we will start comparing from the RIGHT side of the array
         *      - the comparing process goes like this
         *          - we will compare if 9 is SMALLER than 20. YES , 9 is SMALLER, so we move 20 to the 1 index, right
         *              - so the array looks like this : 6 8 12 14 18 __ 20
         *
         *          - we will compare if 9 is SMALLER than 18, YES , 9 is  SMALLER, so we move 18 to the 1 index, right
         *              - so the array looks like this : 6 8 12 14 __ 18 20
         *
         *          - we will compare if 9 is SMALLER than 14, YES , 9 is SMALLER, so we move 14 to the 1 index, right
         *              - so the array looks like this : 6 8 12 __ 14 18 20
         *
         *          - we will compare if 9 is SMALLER than 12, YES , 9 is SMALLER, so we move 12 to the 1 index, right
         *              - so the array looks like this : 6 8 __ 12 14 18 20
         *
         *          - we will compare if 9 is SMALLER than  8, NO, 9 is GREATER, so insert 9 after 8 in the array
         *              - so the array looks like this : 6 8 9 12 14 18 20
         *
         * - Steps:
         *  - we will use FOR loop for iterating through each element of the `arr` variable
         *      - we will call this iterating "passes"
         *
         *  - The for loop will start from index 1 of the `arr` variable
         *  - The for loop will NOT start from index 0 because, we are assuming that, index O is already SORTED
         *
         *  - Then,we will get the value of index 1 and compare with the value at index O
         *  - if the value is in index 1 is smaller, then
         *      - and check which value in the arr is smaller than el
         *    - we will do this checking inside a WHILE loop
         *
         * Time complexity  : O(n^2)
         * Space complexity : O(1)
         * */


        // Starting the for loop from 1 because we are assuming that the first index is already sorted
        int previousIndex =0;
        int currentValue  =0;

        for (int i = 1; i < arr.length; i++) {

            currentValue = arr[i];
            previousIndex = i-1;

            while(previousIndex > -1 && currentValue < arr[previousIndex]){

               // Shifting the element to the right by 1 INDEX
               arr[previousIndex+1] = arr[previousIndex];
               previousIndex--;
            }


            arr[previousIndex+1] = currentValue;
        }
        return arr;
    }
}
