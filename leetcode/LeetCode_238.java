package com.ronok.leetcode;

import java.util.Arrays;

public class LeetCode_238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1})));
    }

    // Brute Force
    public static int[] productExceptSelf(int[] nums) {

        var resultArray = new int[nums.length];

        for (int i = 0; i <nums.length ; i++) {
            var result = 1;
            for (int j = 0; j <nums.length ; j++) {
               if(i != j)
                  result = result * nums[j];
            }
            resultArray[i] = result;
        }
        return resultArray;
    }
}
