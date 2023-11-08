package com.ronok.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class LeetCode_347 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))); //[1,2]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1))); //[1]
        System.out.println(Arrays.toString(topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2))); //[-1,2]
    }

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for (var z:nums){
            map.put(z,map.compute(z, (key, v) -> (v == null) ? 1 : map.get(z)+1));
        }

        var list = new ArrayList<>(map.keySet());

        /*
        * Sorting the MAP based on the value in the Descending Format        * After executing this code, the list will contain the keys from the map sorted based on their values in descending order.
        * The keys with the highest associated values will appear at the beginning of the list, and those with lower values will follow.
        * */
        list.sort((a, b) -> map.get(b) - map.get(a));


        var resultArray = new int[k];

        var count = 0;
        for(var m : list){
            resultArray[count++] = m;
            if(count == k)break;
        }
        return resultArray;
    }

}