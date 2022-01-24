package com.ronok.algoexpert;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args){
        System.out.println(doBinarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73},33)); //OUTPUT: 3
        System.out.println(doBinarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73},72)); //OUTPUT: 8
        System.out.println(doBinarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73},61)); //OUTPUT: 6
        System.out.println(doBinarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73},60)); //OUTPUT: -1
    }

    private static int doBinarySearch(int[] arr,int target) {

        /*
        * - Steps
        *  - In binary Search we use Three variable to Iterate and find a variable
        *  - the 3 variable: Left,Right,Median
        *
        *  - Time Complexity : O(log(n))
        *  - Space Complexity: O(1)
        *   - As we are not doing this in a recursive way that's why the space complexity is O(1)
        *   - if we code this binarySearch in recursive way then
        *     - the space complexity will be O(n)
        *     - because in recursive way we have to use `Stack` data structure in order to keep track of the function calling
        *     - and stack space is proportional to the length of the arr
        * */

        int l =0;
        int r = arr.length-1;
        int m = (int) Math.ceil( (l+r)/2 );
        int index = -1;

        while(l <= r){
            if(arr[m] == target){
                index = m;
                break;
            }
            else if(arr[m] > target){    // when target is small, that means our desired target value will be at the LEFT of the median
               r = m - 1;
               m = (int) Math.ceil(( l+r )/ 2);
            }
            else if(arr[m] < target){   // when target is Larger, that means our desired target value will be at the RIGHT of the median
               l = m +1;
               m = (int) Math.ceil(( l+r )/ 2);
            }
        }
        return index;
    }
}
