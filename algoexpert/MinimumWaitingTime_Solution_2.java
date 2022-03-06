package com.ronok.algoexpert;

import java.util.Arrays;

public class MinimumWaitingTime_Solution_2 {

    public static void main(String[] args){

        /*
           Steps
                3 2 1 2 6

           - we will sort it in descending way, so the array
               3 2 1 2 6
               will be

               1 2 2 3 6

           - Then,
               Let's see what the waiting time looks like for Each Query
               we will do the following calculation

               when 1 will execute the next 4 element will wait for 1 minute,
               so the calculation becomes : 0 +  (1*4)  = 4

               when 2 will execute the next 3 element will wait for 2 minute,
               so the calculation becomes : 4 +  (3*2)  = 10

               when 2 will execute the next 2 element will wait for 2 minute,
               so the calculation becomes : 10 + (2*2)  = 14

               when 3 will execute the next 1 element will wait for 3 minute,
               so the calculation becomes : 14 + (1*3)  = 17


               so, the Total minimum waiting time is : 17


           // Time Complexity  : O(n) where n is the Number of Queries
           // Space Complexity : O(1) where n is the Number of Queries

         */

        int[] queries = {3,2,1,2,6};
        Arrays.sort(queries); // Default is Ascending
        System.out.println(doCalculateTime(queries)); // Expected Output: 17
    }

    private static int doCalculateTime(int[] queries) {

       int sum = 0;
       int numOfElements = 0;

       for(int i = 0; i <= (queries.length - 2); i++){
           numOfElements = queries.length - 1 - i;
           sum = sum + (queries[i]*numOfElements);
       }
       return sum;
    }
}
