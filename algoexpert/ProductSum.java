package com.ronok.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {
    public static void main(String[] args){

        List<Object> listOfObject= new ArrayList<>();
        listOfObject.add(5);
        listOfObject.add(2);
        listOfObject.add(Arrays.asList(7,-1));
        listOfObject.add(3);
        listOfObject.add(Arrays.asList(6,Arrays.asList(-13,8),4));

        // listOfObject :  [5, 2, [7, -1], 3, [6, [-13, 8], 4]]

        System.out.println(doProductSum(listOfObject,1,0)); // Expected Output: 12
    }

    private static int doProductSum(List<Object> listOfObject, int level,int sum) {

        /*
        * Steps
        *   - we can solve this problem with Recursion
        *   - First we have to understand how to Iterate through nested List
        *   - Second we have to understand how recursion works
        *
        *   - while recursion we are keeping track of the Intermediate sum
        *
        *   - we are doing the sum sequentially like below
        *   - 5 + 0 = 5
        *   - add 2 to the above result
        *   - Then recursive call happens for list [7,-1]
        *       - 7+0 = 0
        *       - 7-1 = 6
        *
        *       - now we are going to do this calculation -> LEVEL * the above result (2 * 6)
        *       - while doing recursion we are passing the Level and the SUM as a parameter
        * */

        /*
        * Time Complexity  : O(n) , where n is the Number of element in the Array
        * Space Complexity : O(d) , where d is the number of depth of the Array
        * */


        for(int i=0; i<listOfObject.toArray().length; i++){

            if(listOfObject.get(i) instanceof List){
                int intermediateSum = doProductSum((List<Object>) listOfObject.get(i),level+1,0);
                sum = sum + intermediateSum;
            }
            else{
                sum = sum+ (int) listOfObject.get(i);
            }
        }
        sum = level * sum ;
        return sum;
    }
}
