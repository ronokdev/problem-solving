package com.ronok.algoexpert;

import java.util.Arrays;

public class MinimumWaitingTime_Solution_1 {

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

               1 waiting time 0
               2 waiting time 1         = 1
               2 waiting time 0+1+2     = 3
               3 waiting time 0+1+2+2   = 5
               6 waiting time 0+1+2+2+3 = 8

           Total minimum waiting time is : 17 (8+5+3+1)


           // Time Complexity  : O(n^2) where n is the Number of Queries
           // Space Complexity : O(n) where n is the Number of Queries

         */

        int[] queries = {3,2,1,2,6};
        Arrays.sort(queries); // Default is Ascending
        System.out.println(doCalculateTime(queries,queries.length-1,0));
    }

    private static int doCalculateTime(int[] queries,int indX,int sum) {

        if(indX == 0)
            return sum;

        for(int i=indX-1; i >= 0 ; i--){
            sum = sum + queries[i];
        }

        sum = doCalculateTime(queries,indX-1,sum);

        return sum;
    }
}
