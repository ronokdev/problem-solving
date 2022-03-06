package com.ronok.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClassPhoto {
    public static void main(String[] args){
        ArrayList<Integer> redShirtHeights = new ArrayList<>();
        redShirtHeights.addAll(Arrays.asList(5,8,1,3,4));

        ArrayList<Integer> blueShirtHeights= new ArrayList<>();
        blueShirtHeights.addAll(Arrays.asList(6,9,2,4,5));

        System.out.println(doClassPhoto(redShirtHeights,blueShirtHeights)); // Expected output : true
    }

    private static boolean doClassPhoto(ArrayList<Integer> param1, ArrayList<Integer> param2) {

        /*
        * Steps
        * - we need to Sort the both Array
        * - And then we can compare the First element of the ArrayList to Determine which color shirt will be in the First row
        * - Then we check if all the element is Higher in the second row
        * - if true then we return the `true` value
        * - otherwise we return the `false` value
        *
        * Time Complexity  : O(n log(n) ) where n is the number of Students
        * Space Complexity : O(1)
        * */

        Collections.sort(param1);
        Collections.sort(param2);


        if(param1.get(0) >= param2.get(0))
            return checkTaller(param2,param1);
        else
            return checkTaller(param1,param2);

    }

    private static boolean checkTaller(ArrayList<Integer> firstRow,ArrayList<Integer> secondRow) {

        boolean result = false;
        for(int i=0; i<firstRow.size(); i++){
           if(secondRow.get(i) > firstRow.get(i)){
              result = true;
           }
           else{
               result = false;
               break;
           }
        }

        return result;
    }
}
