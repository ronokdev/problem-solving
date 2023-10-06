package com.ronok.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_1431 {

    public static void main(String[] args){
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3},3));
        System.out.println(kidsWithCandies(new int[]{4,2,1,1,2},1));
        System.out.println(kidsWithCandies(new int[]{12,1,12},10));
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> booleanList = new ArrayList<>();
        var max = Arrays.stream(candies).max();

        for (var x : candies) {
            if (Math.addExact(x, extraCandies) >= max.getAsInt())
                booleanList.add(true);
             else
                booleanList.add(false);
        }
        return booleanList;
    }
}
