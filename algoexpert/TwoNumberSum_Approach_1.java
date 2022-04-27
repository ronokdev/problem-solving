package com.ronok.algoexpert;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TwoNumberSum_Approach_1 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(doTwoSum(new int[]{3,5,-4,8,11,1,-1,6},10))); // Expected Output: [-1,11]
        System.out.println(Arrays.toString(doTwoSum(new int[]{3,5,-4,8,11,1,-1,6},11))); // Expected Output: [3,8]
    }

    private static int[] doTwoSum(int[] array, int targetSum) {

        /*
        * Steps
        *   - Sort the Array in ascending order (small to large)
        *   - [-4,-1,1,3,5,6,8,11]
        *
        *   - use two pointer method
        *       - the first pointer will point to the 1st element and the second pointer will point to the Last element
        *       - then we will add this two number
        *           - if the resulting number is smaller, then we will increment the first  pointer
        *           - if the resulting number is greater, then we will decrement the second pointer
        *           - if we get the targetSum then we will add the numbers that our pointer are pointing to an array
        *           - and return the array
        *
        * - Time complexity  : O(n Log(n)), as we are sorting the array , we are assuming that java uses that fastest in place sorting algo
        * - Space Complexity : O(1)        , as we are not using any additional Space for storing any value
        *
        * */

        Arrays.sort(array);

        int firstPointer = 0;
        int secondPointer = array.length-1;

        for(int i=0; i<array.length-1; i++){

            int runningSum = array[firstPointer] + array[secondPointer];

            if(runningSum == targetSum)
                return new int[]{array[firstPointer],array[secondPointer]};

            else if(runningSum < targetSum)
                firstPointer++;

            else
                secondPointer--;
        }
        return new int[]{};
    }
}
