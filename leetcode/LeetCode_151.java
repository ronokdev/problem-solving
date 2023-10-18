package com.ronok.leetcode;

public class LeetCode_151 {
    public static void main(String[] args){
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("farhan"));
    }

    public static String reverseWords(String s) {
        String[] split = s.trim().replaceAll("\\s+", " ").split(" ");
        var builder = new StringBuilder();
        for(int i = split.length-1; i >= 0;i--){
            builder.append(split[i]);
            if(i != 0 )
                builder.append(" ");
        }
        return builder.toString();
    }

}
