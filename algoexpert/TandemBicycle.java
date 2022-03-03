package com.ronok.algoexpert;

import java.util.Arrays;

public class TandemBicycle {
    public static void main(String[] args){

//        System.out.println(doTandemCalculation(new int[]{5, 5, 3, 9, 2},new int[]{3,6,7,2,1},true));  // Expected output: 32
        System.out.println(doTandemCalculation(new int[]{3,6,7,2,1},new int[]{5,5,3,9,2},false));  // Expected output: 25
    }

    private static int doTandemCalculation(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean isFastest) {

        /*
        * - Steps
        * - maximum possible total speed
        *   - check smallest number of array 1 with the highest number of array 2 and select the HIGHEST
        *
        * 1 2 3 6 7
        * 2 3 5 5 9
        *
        * selecting array
        * 9 5 5 6 7
        * sum : 32
        *
        * - minimum possible total speed
        *  - check highest number of array 1 with the highest number of array 2 and select the HIGHEST
        *
        * 1 2 3 6 7
        * 2 3 5 5 9
        *
        * selecting array
        * 2 3 5 6 9
        * sum : 25

        *
        * Time Complexity : O(nlog(n))
        * Space Complexity: O(1) , we are assuming that the java default array sort uses in-place sorting
        * */


        // Sorting the Array inorder to Compare
        Arrays.sort(redShirtSpeeds); // Default sorting is ascending
        Arrays.sort(blueShirtSpeeds);

        int sum = 0;

            for(int i= 0; i<redShirtSpeeds.length; i++){

                if(isFastest) {
                    sum = sum + Math.max(blueShirtSpeeds[redShirtSpeeds.length - 1 - i], redShirtSpeeds[i]);
                    continue;
                }
                sum = sum + Math.max(blueShirtSpeeds[i], redShirtSpeeds[i]);
            }
            return sum;
    }
}
