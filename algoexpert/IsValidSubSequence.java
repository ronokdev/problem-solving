package com.ronok.algoexpert;

import java.util.Arrays;
import java.util.List;

public class IsValidSubSequence {
    public static void main(String[] args){
        System.out.println(isValidSubsequence(Arrays.asList(5,1,22,25,6,-1,8,10),Arrays.asList(1,6,-1,10))); // Expected Output: true
        System.out.println(isValidSubsequence(Arrays.asList(5,1,22,25,6,-1,8,10),Arrays.asList(1)));         // Expected Output: true
        System.out.println(isValidSubsequence(Arrays.asList(5,1,22,25,6,-1,8,10),Arrays.asList(9)));         // Expected Output: false
        System.out.println(isValidSubsequence(Arrays.asList(9),Arrays.asList(9)));                           // Expected Output: true
    }

    private static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        /*
        * we will use two pointer approach here
        * the first  pointer will point to the first index of the `array` variable
        * the second pointer will point to the first inder of the `sequence` variable
        *
        * we will run a loop on the `array` variable and check
        *   if the first pointer value matches with the second pointer value
        *       Then we will increment the both pointer by 1
        *       if it does not match then we will increment only the first pointer by 1 and the second pointer will remain un change
        *
        * we will break the loop if
        *   the  first pointer reaches the end of the `array` variable OR
        *   the second pointer reaches the end of the `sequence` variable
        *
        * Finally,
        *   we will return True
        *       if the second pointer is EQUAL to the size of `sequence` variable
        *
        *       Explanation
        *           - For `array`    -> 5,1,22,25,6,-1,8,10
        *           - For `sequence` -> 1,6,-1,10
        *           - when the second pointer will point to the value `10` of `sequence` variable
        *               the value of second pointer will be 3 and on line 49 we are incrementing the second pointer value
        *               so, the for loop will break and the second pointer value will be `4` which is equal to the `sequence.size()`
        *
        *               and when the second pointer value will be equal to the `sequence.size()`, we are returning TRUE
        *               otherwise we are returning FALSE.
        *
        *
        *       Time Complexity  : O(n), where n is the number of element in `array` variable
        *       space Complexity : O(1), because we are not using any Additional Space
        * */

        int pointer1 = 0;
        int pointer2 = 0;

        for(int i=0; i<array.size(); i++){

            if(pointer1 > array.size() -1 || pointer2  > sequence.size()-1)
                break;

            if(array.get(pointer1) == sequence.get(pointer2)){
               pointer1++;
               pointer2++;
            }
            else{
                pointer1++;
            }
        }

        if(pointer2 == sequence.size())
            return true;

        return false;
    }
}