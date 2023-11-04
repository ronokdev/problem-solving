package com.ronok.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_242 {
    public static void main(String[] args){
        System.out.println("with arrayDeque");
        System.out.println(isAnagram("anagram","nagaram")); // true
        System.out.println(isAnagram("rat","cat")); // false

        System.out.println("withOut arrayDeque");
        System.out.println(isAnagram2("anagram","nagaram"));// true
        System.out.println(isAnagram2("rat","cat"));// false

        System.out.println("with calculating frequency of characters");
        System.out.println(isAnagram3("anagram","nagaram"));// true
        System.out.println(isAnagram3("rat","cat"));// false
    }

    public static boolean isAnagram(String s, String t) {
        var deque = new ArrayDeque<>();

        if(s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++)
            deque.addFirst(s.charAt(i));

        for (int j = 0; j < t.length(); j++)
            deque.remove(t.charAt(j));

        return deque.isEmpty();
    }

    public static boolean isAnagram2(String s, String t) {

        var s1 = s.toCharArray();
        var s2 = t.toCharArray();

        if(s1.length != s2.length)
            return false;

        Arrays.sort(s1);
        Arrays.sort(s2);

        for (int i = 0; i < s1.length; i++) {
            if(s1[i] != s2[i]){
                return false;
            }
        }
        return true;
    }

    // By checking the frequency of each letter
    public static boolean isAnagram3(String s, String t) {

        var s1 = s.toCharArray();
        var s2 = t.toCharArray();

        if(s1.length != s2.length)
            return false;

       HashMap<Character,Integer> hashMap = new HashMap<>() ;

        for (char c : s1) {
            if (!hashMap.containsKey(c)) {
                hashMap.putIfAbsent(c, 1);
            }
            else
                hashMap.put(c,hashMap.get(c)+1);
        }

        for (char c1 : s2) {
            if (!hashMap.containsKey(c1)) {
                return false;
            }
            else
                hashMap.put(c1,hashMap.get(c1)-1);
        }

        for(var c3:hashMap.values()){
            if(c3 != 0)
                return false;
        }
        return true;
    }
}
