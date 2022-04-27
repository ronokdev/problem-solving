package com.ronok.algoexpert;

import java.util.Arrays;
import java.util.HashSet;

public class TwoNumberSum_Approach_2 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(doTwoSum(new int[]{3,5,-4,8,11,1,-1,6},10))); // Expected Output: [-1,11]
        System.out.println(Arrays.toString(doTwoSum(new int[]{3,5,-4,8,11,1,-1,6},11))); // Expected Output: [8,3]
        System.out.println(Arrays.toString(doTwoSum(new int[]{4,6},10))); // Expected Output: [6,4]
    }

    private static int[] doTwoSum(int[] array, int targetSum) {

        /*
        * Steps
        *   - we will use Hashset
        *   - we will iterate over the `array` variable from first to Last , only one time
        *   - Here goes the calculation
        *   - For `array` -> [3,5,-4,8,11,1,-1,6] and targetSum = 10
        *
        *   - First index of the array is 3
        *   - so, 10 - 3 = 7
        *       - then we will check if 7 is present in the Hashset
        *           - if 7 is present then we will add 3 and 7 in an array and return it
        *           - if 7 is NOT present
        *           - then
        *               - we will add 3 (NOT 7) to the Hashset and Move on to the next element of the array
        *
        *
        * - Time complexity  : O(n), where n is the number of element in the Array
        * - space complexity : O(n), because, we are using a Hashset and , the length of the HashSet is proportional to the length of the Array
        * */

        HashSet<Integer> arrayHash = new HashSet<>();

        for(int i=0; i < array.length ; i++){

            int runningResult = targetSum - array[i];

            if(arrayHash.contains(runningResult))
                return new int[]{array[i],runningResult};
            else
                arrayHash.add(array[i]);
        }

        return new int[]{};
    }
}
