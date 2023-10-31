package com.ronok.leetcode;

import java.util.Arrays;

public class LeetCode_238 {
    public static void main(String[] args) {
        System.out.println("with brute force");
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4}))); // output : [24, 12, 8, 6]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3}))); // output : [0, 0, 9, 0, 0]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1}))); // output : [1, -1]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0,0}))); // output : [0, 0]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0,4,0}))); // output : [0, 0, 0]

        System.out.println("without brute force");
        System.out.println(Arrays.toString(productExceptSelf1(new int[]{1,2,3,4}))); // output : [24, 12, 8, 6]
        System.out.println(Arrays.toString(productExceptSelf1(new int[]{-1,1,0,-3,3}))); // output : [0, 0, 9, 0, 0]
        System.out.println(Arrays.toString(productExceptSelf1(new int[]{-1,1}))); // output : [1, -1]
        System.out.println(Arrays.toString(productExceptSelf1(new int[]{0,0}))); // output : [0, 0]
        System.out.println(Arrays.toString(productExceptSelf1(new int[]{0,4,0}))); // output : [0, 0, 0]
    }

    // Brute Force with O(n2) time complexity and O(1) space complexity
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

    // O(n2) time complexity and O(n) space complexity
    /*
    * we need to calculate product of the left side of the element and store it to an array, and
    * we need to calculate product of the right side of the element and store it to an array and
    * then make multiplication of those two array
    * */
    public static int[] productExceptSelf1(int[] nums) {

        var n = nums.length;

        var leftProduct = new int[n];
        var rightProduct = new int[n];
        var result = new int[n];

        leftProduct[0] = 1;
        rightProduct[n-1] = 1;

        for (int i = 1; i < n; i++) {
            leftProduct[i] =  nums[i-1] * leftProduct[i-1];
        }

        for (int i = n-2; i >= 0; i--) {
            rightProduct[i] = nums[i+1] * rightProduct[i+1];
        }

        for (int j = 0; j < n; j++) {
            result[j] = leftProduct[j]*rightProduct[j];
        }
        return result;

    }

}
