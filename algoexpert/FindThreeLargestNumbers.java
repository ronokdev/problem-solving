package com.ronok.algoexpert;

import java.util.Arrays;

public class FindThreeLargestNumbers {
    public static void main(String[] args){
        System.out.println(Arrays.toString(doFindThreeLargestNumbers(new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7}))); //OUTPUT: [18, 141, 541]
    }

    private static int[] doFindThreeLargestNumbers(int[] arr) {

        /*
        * - Steps
        *   - we can use modified bubble sort to solve this problem
        *   - we use two loops for bubble sort, and we can maintain the number of iteration of the 2nd loop with a variable
        *   - we know that, after each pass we get the largest value at the end of the array in Bubble Sort
        *   - we use this technique to solve this problem
        * */
        int pass =0;
        int temp =0;

        for(int i=0;i<arr.length;i++){  // we use this loop to count passes
            pass++;

            for(int j=0;j<arr.length-1-i;j++){
               if(arr[j] > arr[j+1]) {
                   temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
            }
            if(pass == 3) break;
        }

        return new int[] {arr[arr.length-3],arr[arr.length-2],arr[arr.length-1]};
    }
}
