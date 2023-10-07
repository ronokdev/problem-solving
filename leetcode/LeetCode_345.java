package com.ronok.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LeetCode_345 {

    public static void main(String[] args){
        System.out.println(reverseVowels("fuad")); // faud
        System.out.println(reverseVowels("FARHANe")); // FeRHANA
        System.out.println(reverseVowels("hello")); // holle
        System.out.println(reverseVowels("leetcode")); // leotcede
        System.out.println(reverseVowels("race a car")); // raca e car
    }


    public static String reverseVowels(String s) {

        var set = new HashSet<>(List.of(
            'a','A',
            'e','E',
            'i','I',
            'o','O',
            'u','U'));

        var charArray = s.toCharArray();

        if(charArray.length == 1)
            return s;

        var p1 = 0;
        var p2 = charArray.length-1;

        while (p1 < p2){

            if(!set.contains(charArray[p1]) && !set.contains(charArray[p2])){
                p1++;
                p2--;
            }

            if(set.contains(charArray[p1]) && set.contains(charArray[p2])){
                var temp = charArray[p1] ;
                charArray[p1] = charArray[p2];
                charArray[p2] = temp;
                p1++;
                p2--;

                continue;
            }

            if(set.contains(charArray[p1])){
                p2--;
                continue;
            }

            if(set.contains(charArray[p2])){
                p1++;
            }
        }
        return new String(charArray);
    }
}
