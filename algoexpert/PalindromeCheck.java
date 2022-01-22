package com.ronok.algoexpert;

public class PalindromeCheck {
    public static void main(String[] args){
        System.out.println(doPalindromeCheck("abcdcba")); // correct output : true
        System.out.println(doPalindromeCheck("abcdcb"));  // correct output : false
        System.out.println(doPalindromeCheck("abba"));    // correct output : true
        System.out.println(doPalindromeCheck("racecar")); // correct output : true
    }

    private static boolean doPalindromeCheck(String str) {

        /*
        * we are going to use TWO pointer approach for this problem
        *
        * Time Complexity  : O(n)
        * space Complexity : O(1)
        * */


        int p1 =0;
        int p2 =str.length()-1;

        while(p1 < p2){
            if(str.charAt(p1) == str.charAt(p2)){
                p1++;
                p2--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
