package com.ronok.algoexpert;

public class CaesarCipherEncryptor {
    public static void main(String[] args){
        /*
        * Steps
        *  - iterate through the STRING
        *  - get the ascii value of  every char
        *  - mod the key with 26 because, we are assuming that our string will only contain small alphabet
        *  - add the new key to the ascii value of a char
        *   - after adding, if the summation is greater less or equal to 122
        *       - Then we just print the char for the ascii code
        *   - if not then
        *       - we mod the summation with 122 and
        *       - add the mod result with 96 and
        *       - then get char with the ascii value
        *   - we are using stringbuilder because it is a mutable class
        *   - the ascii value of a is 97
        *   - the ascii value of z is 122
        *
        *   - time complexity  : O(n)
        *   - Space complexity : O(n)
        * */

        System.out.println(doCaesarCipherEncryptor("xyz",2)); // Expected output: zab
        System.out.println(doCaesarCipherEncryptor("xyz",3)); // Expected output: abc
        System.out.println(doCaesarCipherEncryptor("aaa",1)); // Expected output: bbb
        System.out.println(doCaesarCipherEncryptor("aaa",0)); // Expected output: aaa
    }

    private static String doCaesarCipherEncryptor(String str, int key) {
        int asciVal =0;
        int desiredAsciVal =0;

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<str.length(); i++){

            asciVal = str.charAt(i);
            desiredAsciVal = asciVal + (key%26);

            if(desiredAsciVal <= 122){
                sb.append((char)desiredAsciVal);
                continue;
            }

            int mod = desiredAsciVal % 122;
            desiredAsciVal = 96+mod;
            sb.append((char)desiredAsciVal);
        }

        return sb.toString();
    }

}
