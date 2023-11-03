package com.ronok.leetcode;

public class LeetCode_334 {
    public static void main(String[] args){

        System.out.println("with brute force");
        System.out.println(increasingTripletBruteForce(new int[]{1,2,3,4,5})); // true
        System.out.println(increasingTripletBruteForce(new int[]{5,4,3,2,1})); // false
        System.out.println(increasingTripletBruteForce(new int[]{2,1,5,0,4,6})); // true
        System.out.println(increasingTripletBruteForce(new int[]{2})); // false
        System.out.println(increasingTripletBruteForce(new int[]{2,2})); // false
        System.out.println(increasingTripletBruteForce(new int[]{1,1})); // false
        System.out.println(increasingTripletBruteForce(new int[]{1,1,2})); // false
        System.out.println(increasingTripletBruteForce(new int[]{20,100,10,12,5,13})); // true

        System.out.println("without brute force");
        System.out.println(increasingTriplet(new int[]{1,2,3,4,5})); // true
        System.out.println(increasingTriplet(new int[]{5,4,3,2,1})); // false
        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6})); // true
        System.out.println(increasingTriplet(new int[]{2})); // false
        System.out.println(increasingTriplet(new int[]{2,2})); // false
        System.out.println(increasingTriplet(new int[]{1,1})); // false
        System.out.println(increasingTriplet(new int[]{1,1,2})); // false
        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,13})); // true
    }

    public static boolean increasingTripletBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i] < nums[j] && nums[j] < nums[k] )
                        return true;
                }
            }
        }
        return false;
    }

    /*
    * we need to keep track of the two smallest element in the array and if we find a third element that is bigger than both(two smallest elements) then
    * we return True
    * otherwise we return false
    * */
    public static boolean increasingTriplet(int[] nums) {
        var first = Integer.MAX_VALUE;
        var second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first)
                first = num;
            else if (num <= second)
                second = num;
            else
                return true;
        }
        return false;
    }

}
