package com.ronok.algoexpert;

public class RunLengthEncoding {
    public static void main(String[] args) {
        System.out.println(doRunLengthEncoding("AAAAAAAAAAAAABBCCCCDD")); //possible output: 9A4A2B4C2D
        System.out.println(doRunLengthEncoding("aA"));                    //possible output: 1a1A
        System.out.println(doRunLengthEncoding("122333"));                //possible output: 112233
    }

    private static String doRunLengthEncoding(String inputStr) {
        /*
        * Steps
        *   - we use sliding window pattern for this problem
        *   - we get two window pointer variable, one counter variable
        *   - Iterate through every character
        *   - check if the same char count is 9 OR current character does not match with the next character
        *   - If one of the condition is TRUE then
        *     - window pointer 2 will be windowPointer1
        *     - counter will be set to ZERO
        *
        *   - if Both the conditions are false then
        *   - we increment the counter and windowPointer2
        * */

        StringBuilder sb = new StringBuilder();
        char[] chArr = inputStr.toCharArray();

        int windowPointer1 = 0;
        int windowPointer2 = 1;
        int count = 1;

        for(int i=0; i<chArr.length; i++){

            if(windowPointer2 == chArr.length) continue;

            if(count == 9 || (chArr[windowPointer1] != chArr[windowPointer2])){
                sb.append(count).append(chArr[windowPointer1]);
                windowPointer1 = windowPointer2;
                count = 0;
            }

            windowPointer2++;
            count++;
        }

        sb.append(count).append(chArr[windowPointer1]);
        return sb.toString();
    }
}

