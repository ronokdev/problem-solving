package com.ronok.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));      // [1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 5)));      // [0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 7)));      // [0, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));         // [0, 1]
    }

    // with brute force
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target)
                    return new int[]{i,j};
            }
        }
        return new int[]{};
    }

    // with hashMap
    public static int[] twoSum1(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(target-nums[i]))
                map.put(nums[i],i);
            else
                return new int[]{map.get(target-nums[i]),i};
        }
        return new int[]{};
    }
}
