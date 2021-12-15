package com.ronok.miscellaneous;


public class ReplaceAllQuestionMark {

    /*
    * Question : 1576.Replace-All-?-to-Avoid-Consecutive-Repeating-Characters of [a,b]
    *
    * input  1:  aa??aab???
    * output 1: aabbaababa
    *
    * input  2: aa??aabb??
    * output 2: aabbaabbab
    *
    * input  3: ?????
    * output 3: ababa
    *
    **/


    /**
     * Steps :
     *  - left to right iteration
     *  - keeping track of the previous and next element
     *  - if ? found check previous and next
     *  - check the first and last element explicitly
     * */

    public static void main(String[] args){
        replaceAllQuestionmarsk("aa??aab???");
        replaceAllQuestionmarsk("aa??aabb??");
        replaceAllQuestionmarsk("aa??aa?b??");
        replaceAllQuestionmarsk("???????");
    }

    private static char qMark= '?';
    private static char aMark= 'a';
    private static char bMark= 'b';

    private static void replaceAllQuestionmarsk(String str) {
        char[] c = str.toCharArray();

        for(int i=0 ; i<c.length ; i++){

            // if no question mark found then continue the LOOP
            if(c[i] != qMark) continue;

            if(c.length == 1){
                c[i] = c[i] == qMark ? aMark : bMark;
            }

            if(i ==0){
                c[i] = alternativeChar(c[i+1]);
            }

            else{
                if(i == c.length -1){
                    c[i] = alternativeChar(c[i-1]);
                    continue;
                }
                //get the previous element
                char tmp = c[i-1];
                c[i] = (c[i+1] == tmp) || (c[i+1] == qMark || c[i-2] == tmp) ? alternativeChar(tmp) : tmp;
            }
        }
        System.out.println(c);
    }

    private static char alternativeChar(char tmp) {
        if(tmp == aMark)
            return bMark;

        return aMark;
    }
}
