package com.ronok.algoexpert;

import java.util.HashMap;

public class GenerateDocument_Approach2 {
    public static void main(String[] args){
        System.out.println(doGenerateDocument("abcabc", "aabbccc")); // output should be : false
        System.out.println(doGenerateDocument("abc abc", "aa bbcc")); // output should be : true
        System.out.println(doGenerateDocument("helloworldO", "hello wOrld")); // output should be : false
        System.out.println(doGenerateDocument("Bste!hetsi ogEAxpelrt x ", "AlgoExpert is the Best!")); // output should be : true
    }

    private static boolean doGenerateDocument(String characters, String document) {

        /**
         * we iterate through the 'characters' string and
         * keep track of the FREQUENCY of each and every character in a hashmap.
         * hashmap format :: hashmap<char,freq>
         *
         * then we iterate through 'document' string
         * and subtract each frequency of the char from the hashmap
         * if we find any char with freq less than 0, then we return false
         * if we do not find a char from 'document' in the hashmap we return false
         * if this iteration is fully complete that means we can generate the document and return true
         * */

        /**
         * Time complexity  - O(c+d) as , we have two parameters in this method
         * Space complexity - O(c)   as , we are creating a hashmap using the 'characters' String
         * */

        HashMap<Character,Integer> hashMap = new HashMap<>();

        char[] charArr = characters.toCharArray();

        for(int i=0; i<charArr.length; i++){

            if(hashMap.containsKey(charArr[i])){
                hashMap.put(charArr[i],hashMap.get(charArr[i])+1);
                continue;
            }
            hashMap.put(charArr[i],1);
        }

        char[] docArr = document.toCharArray();

        for(int j=0; j<docArr.length; j++){

            if(hashMap.containsKey(docArr[j])){
                hashMap.put(docArr[j],hashMap.get(docArr[j])-1);

                if(hashMap.get(docArr[j]) < 0)
                    return false;
            }
            else
                return false;
        }
        return true;
    }
}
