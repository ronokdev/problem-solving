package com.ronok.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class GenerateDocument {
    public static void main(String[] args) {
        System.out.println(doGenerateDocument("abcabc", "aabbccc"));
        System.out.println(doGenerateDocument("Bste!hetsi ogEAxpelrt x ", "AlgoExpert is the Best!"));
    }

    private static boolean doGenerateDocument(String characters, String document) {

        /**
         * Put the document string in the list
         * loop through each char in the characters and
         * then remove the char from the list
         * then return the hashmap is empty or not
         * */


        /**
         * Time  Complexity : O(n+m) : n is the number of characters, m is the length of the document
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
