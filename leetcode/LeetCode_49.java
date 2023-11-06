package com.ronok.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LeetCode_49 {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"})); // [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(groupAnagrams(new String[]{""})); // [[]]
        System.out.println(groupAnagrams(new String[]{"a"})); // [["a"]]
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(var z:strs){
            var charArray =z.toCharArray();
            Arrays.sort(charArray);

            if(!map.containsKey(Arrays.toString(charArray))){
                map.put(Arrays.toString(charArray),new ArrayList<>()) ;
            }
           map.get(Arrays.toString(charArray)).add(z);
        }
        return new ArrayList<>(map.values());
    }
}
