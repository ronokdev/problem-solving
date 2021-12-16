package com.ronok.miscellaneous;

import java.util.*;

/**
 * write a java program for you are given a string representing a sequence of N arrows,each pointing in one of the
 * four cardinal directions:up(^),down(v),left(<),right(>) .
 * write a function solution that,given a string S denoting the direction of the arrows,
 * returns the minimum number of arrows that must be rotated to make them all point in the same direction.
 * */

public class MinimumNumberOfRotatedArrow {
    public static void main(String[] args){

        System.out.println(doMinimumNumberOfRotatedArrows("^<>v<<^v^<><v<^<>>^vv"));
        System.out.println(doMinimumNumberOfRotatedArrows("^<<vvv^^^v^^^^^"));
        System.out.println(doMinimumNumberOfRotatedArrows("vvvvvvvvvvv"));
        System.out.println(doMinimumNumberOfRotatedArrows("vvvvvvv>vvv"));
        System.out.println(doMinimumNumberOfRotatedArrows("v>^"));
        System.out.println(doMinimumNumberOfRotatedArrows("^^><<>^"));
    }

    private static int doMinimumNumberOfRotatedArrows(String str) {
        /**
         * Steps
         *  Get the number of each arrow type in the str
         *  Find the maximum number of arrow type
         *  return the Total - maximum
         *  which is the SUM of all the arrow types except the maximum arrow type
         * */


        final char upArrow = '^';
        final char downArrow = 'v';
        final char leftArrow = '<';
        final char rightArrow = '>';

        int upArrowCount =0;
        int downArrowCount =0;
        int leftArrowCount =0;
        int rightArrowCount =0;


        for (int i=0; i<str.length();i++){

            if(str.charAt(i) == upArrow) ++upArrowCount;
            else if(str.charAt(i) == downArrow) ++downArrowCount;
            else if(str.charAt(i) == leftArrow) ++leftArrowCount;
            else if(str.charAt(i) == rightArrow) ++rightArrowCount;
        }

        Integer[] totalArrow = {upArrowCount,downArrowCount,leftArrowCount,rightArrowCount};

        int max = Collections.max(Arrays.asList(totalArrow));
        int total = Arrays.stream(totalArrow).reduce(0, (a,b) -> a+b);

        return (total - max);
    }
}
