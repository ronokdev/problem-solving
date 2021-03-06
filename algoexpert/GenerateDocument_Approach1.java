package com.ronok.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class GenerateDocument_Approach1 {
    public static void main(String[] args) {
        System.out.println(doGenerateDocument("abcabc", "aabbccc"));
        System.out.println(doGenerateDocument("Bste!hetsi ogEAxpelrt x ", "AlgoExpert is the Best!"));
    }

    private static boolean doGenerateDocument(String characters, String document) {

        /**
         * Put the document string in the list
         * loop through each char in the characters and
         * then remove the char from the list
         * then return the if the list is empty or not
         * */


        /**
         * Time  Complexity : O(n^2) : because in the second array we are doing a linear operation and the
         * time complexity of indexOf is also O(n)
         * so we are taking O(n^2) time
         *
         * space Complexity : O(c)   : c is the number of characters
         * */

        if (characters.length() == 0)
            return true;

        List<Character> docList = new ArrayList<>();
        for (int i = 0; i < document.length(); i++) {
            docList.add(document.charAt(i));
        }


        for(int j=0; j<characters.length() ;j++){

            int index = docList.indexOf(characters.charAt(j));

            if(index == -1)continue;
            docList.remove(index);
        }

        return docList.isEmpty();
    }
}
