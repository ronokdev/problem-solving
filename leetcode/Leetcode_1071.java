package com.ronok.leetcode;

public class Leetcode_1071 {

    public static void main(String[] args){
        System.out.println(gcdOfStrings("abcabc","abc"));
        System.out.println(gcdOfStrings("ababab","abab"));
        System.out.println(gcdOfStrings("LEFT","CODE"));
        System.out.println(gcdOfStrings("ABCDEF","ABC"));
    }

    public static String gcdOfStrings(String str1, String str2) {

        if(str2.length() > str1.length())
            return gcdOfStrings(str2,str1);

        else if(!str1.startsWith(str2))
            return "";

        else if(str2.isEmpty())
            return str1;

        else
           return gcdOfStrings(str1.substring(str2.length()),str2);
    }
}
