package com.ronok.miscellaneous;

/**
 * problem
 *  You are given a string S. Deletion of the K-th letter of S costs C[K]. After deleting a letter, the cost of deleting other letters
 *  do not change.
 *
 *  for Example
 *      for S= "ab" and C = [1,3], after deleting 'a', deletion of 'b' will still cost 3.
 *
 *  Write a function that, given string S and array C of integers, both of length N, returns the minimum cost of all necessary deletions.
 * */

public class MaximumCostOfDeletion {


    public static void main(String[] args){
        int[] c = {0,1,2,3,4,5};
        int[] c1 = {3,4,5,6};
        int[] c2 = {10,5,10,5,10};
        int[] c3 = {1,2,1,2,1,2};
        int[] c4 = {2,2};

        System.out.println(doCalculation("abccbd", c));
        System.out.println(doCalculation("aaaa",   c1));
        System.out.println(doCalculation("ababa",  c2));
        System.out.println(doCalculation("aabbcc", c3));
        System.out.println(doCalculation("aa", c4));
    }

    private static int doCalculation(String str,int[] c) {
        /**
         * define two pointers
         * define a int for keeping track of the sum
         * pointer 1 will point to 1st char
         * pointer 2 will point to 2nd Char
         * for loop iteration from left to right
         * check if the char is same
         *  if same then
         *      check the lower number on array c [index will be the same as str]
         *      get the lower element
         *      keep the track of the sum
         *  if not same
         *      then increment both the pointers by 1
         *  check for the edge case like
         *      if the length of str is 1
         * */

        int tSum =0;

        for(int i =0; i<str.length(); i++){

            if(i == str.length() -1)continue;

            if(str.charAt(i) != str.charAt(i+1)) {
                continue;
            }

            int smaller = getSmaller(c[i], c[i+1]);

            tSum = tSum + smaller;
        }
        return tSum;
    }

    private static int getSmaller(int first, int second) {
        if(first < second)
            return first;

        return second;
    }
}
