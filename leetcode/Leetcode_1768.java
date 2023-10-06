package com.ronok.leetcode;

public class Leetcode_1768 {

    public static void main(String[] args){
        System.out.println(mergeAlternately("abc","pqr"));
        System.out.println(mergeAlternately("ab","pqrs"));
        System.out.println(mergeAlternately("abcd","pq"));
    }
    public static String mergeAlternately(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        int p1 =0;
        int p2 =0;

        StringBuilder result = new StringBuilder();

        while (p1 < length1 && p2 < length2){
            result.append(word1.charAt(p1)).append(word2.charAt(p2));
            p1++;
            p2++;
        }

        if(p1 < length1)
            result.append(String.valueOf(word1.toCharArray(),p1,length1-p1));

        if(p2 < length2)
            result.append(String.valueOf(word2.toCharArray(),p2,length2-p2));

        return result.toString();
    }
}
