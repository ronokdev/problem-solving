package com.ronok.algoexpert;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args){
        System.out.println(doFirstNonRepeatingCharacter("abcdcaf"));
        System.out.println(doFirstNonRepeatingCharacter("aabbcc"));
        System.out.println(doFirstNonRepeatingCharacter("aabbccf"));
        System.out.println(doFirstNonRepeatingCharacter("aaaaaaaaaaallllaccd"));
    }

    private static int doFirstNonRepeatingCharacter(String str) {

        /**
         * Loop through the str
         * insert the number of occurrence in the Linked hashmap
         * we are using the Linked hashmap to, preserve the order of Insertion
         * then again loop through the str
         * find the occurrence of each char in str
         * return the index of the char with the occurrence == 1
         * */


        /*
        * Time Complexity : O(n)
        * space complexity : O(1) because, in the question it's said that the input only contains SMALL english letters
        * as there is only 26 english small letters , thus we can say that our hashmap will not be bigger than 26
        * thus we can say that space complexity is O(1)
        * */

        HashMap<Character,Integer> hashMap = new LinkedHashMap<>();

        for(int i=0; i<str.length();i++){
            if(hashMap.containsKey(str.charAt(i))){
                hashMap.put(str.charAt(i),hashMap.getOrDefault(str.charAt(i),0)+1);
                continue;
            }
            hashMap.put(str.charAt(i),1);
        }

        for(int i=0; i<str.length();i++)
            if(hashMap.get(str.charAt(i)) == 1)
                return i;

        return -1;
    }
}
