package com.ronok.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_217 {
    public static void main(String[] args){
        System.out.println("with two pointer");
        System.out.println(containsDuplicate(new int[]{1,2,3,1})); // true
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));// false
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2})); // true
        System.out.println(containsDuplicate(new int[]{1})); // false;
        System.out.println(containsDuplicate(new int[]{1,2})); // false;
        System.out.println(containsDuplicate(new int[]{1,1})); // true;

        System.out.println("with HashSet");
        System.out.println(containsDuplicate2(new int[]{1,2,3,1})); // true
        System.out.println(containsDuplicate2(new int[]{1,2,3,4}));// false
        System.out.println(containsDuplicate2(new int[]{1,1,1,3,3,4,3,2,4,2})); // true
        System.out.println(containsDuplicate2(new int[]{1})); // false;
        System.out.println(containsDuplicate2(new int[]{1,2})); // false;
        System.out.println(containsDuplicate2(new int[]{1,1})); // true;
    }

    // with two pointer approach
    public static boolean containsDuplicate(int[] nums) {
        if(nums.length == 1)
            return false;

        Arrays.sort(nums);

        var p1=0;
        var p2=1;

        while (p2 < nums.length){
           if(nums[p1] == nums[p2])
               return true;
           else{
               p1++;
               p2++;
           }
        }
        return false;
    }

    // with hash set
    public static boolean containsDuplicate2(int[] nums) {

        var hashSet = new HashSet<>();

        for(var z:nums){
            if(!hashSet.contains(z))
                hashSet.add(z);
            else
                return true;
        }
        return false;
    }
}
