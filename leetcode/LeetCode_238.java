package com.ronok.leetcode;

import java.util.Arrays;

public class LeetCode_238 {
    public static void main(String[] args) {
//        System.out.println("with brute force");
//        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4}))); // output : [24, 12, 8, 6]
//        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3}))); // output : [0, 0, 9, 0, 0]
//        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1}))); // output : [1, -1]
//        System.out.println(Arrays.toString(productExceptSelf(new int[]{0,0}))); // output : [0, 0]
//        System.out.println(Arrays.toString(productExceptSelf(new int[]{0,4,0}))); // output : [0, 0, 0]
//
//        System.out.println("without brute force");
//        System.out.println(Arrays.toString(productExceptSelf1(new int[]{1,2,3,4}))); // output : [24, 12, 8, 6]
//        System.out.println(Arrays.toString(productExceptSelf1(new int[]{-1,1,0,-3,3}))); // output : [0, 0, 9, 0, 0]
//        System.out.println(Arrays.toString(productExceptSelf1(new int[]{-1,1}))); // output : [1, -1]
//        System.out.println(Arrays.toString(productExceptSelf1(new int[]{0,0}))); // output : [0, 0]
//        System.out.println(Arrays.toString(productExceptSelf1(new int[]{0,4,0}))); // output : [0, 0, 0]

        System.out.println("with constant space");
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{1,2,3,4}))); // output : [24, 12, 8, 6]
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{-1,1,0,-3,3}))); // output : [0, 0, 9, 0, 0]
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{-1,1}))); // output : [1, -1]
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{0,0}))); // output : [0, 0]
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{0,4,0}))); // output : [0, 0, 0]

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

    // O(n) time complexity and O(n) space complexity
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

    // O(n) time complexity and O(1) space complexity
    /*
     * we need to calculate product of the left side of the element and store it to an array, and
     * we start iterating from the right to left,
     *      and we keep track of the product of the right side of the element,
     *      and we update the tracking variable
     *
     * Explanation
     *      original array [1, 2, 3, 4] and left product array [1, 1, 2, 6]
     *      so start iterating from right to left 4 -> 3 -> 2 -> 1 of the original array and
     *          for element 4 the right product is 1 (we are tracking this counter variable), and we multiply this 1 with the last element of the left product array 6*1 = 6
     *          for element 3 the right product is 4 (we are tracking this counter variable), and we multiply this 4 with the last element of the left product array 2*4 = 8
     *          for element 2 the right product is 12 (we are tracking this counter variable) , and we multiply this 1 with the last element of the left product array 1*12 = 12
     *          for element 1 the right product is 24 (we are tracking this counter variable) , and we multiply this 1 with the last element of the left product array 1*24 = 24
     *      and the result is [24, 12, 8, 6]
     * */
    public static int[] productExceptSelf2(int[] nums) {

        var n = nums.length;
        var counter = 1;

        var leftProduct = new int[n];

        leftProduct[0] = 1;

        for (int i = 1; i < n; i++) {
            leftProduct[i] =  nums[i-1] * leftProduct[i-1];
        }

        for (int i = n-1; i >= 0; i--) {
            leftProduct[i] = leftProduct[i] * counter;
            counter = counter * nums[i];
        }
        return leftProduct;
    }
}
