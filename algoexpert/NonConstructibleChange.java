package com.ronok.algoexpert;

import java.util.Arrays;

public class NonConstructibleChange {
    public static void main(String[] args){

       /*
       * 5 7 1 1 2 3 22
       * Steps
       *    - Sort the Array in the ascending order
       *        - 1 1 2 3 5 7 22
       *    - Then we will declare a variable `change`
       *    - The initial value of the change is ZERO
       *    - Then we will add all the element in the array and check if the next element in the array is greater than our `change` + 1
       *    - Explanation
       *        - At first our `change` is = 0
       *        - we add `change` + first element of the array (1), and `change` becomes -> 1
       *        - Then, we iterate to the next element and check if this element of the array (1) is greater than `change+1`
       *        - Then, we continue repeating the steps
       *        - when we reach the last element of the array (22)
       *            - the `change` becomes 19 (1+1+2+3+5+7)
       *            - and we check if the current element (22) is greater than `change+1`
       *            - the current element (22) is greater than `change+1`
       *            - so we return `change+1`
       *        - if we iterate through the array without finding the next element, which is greater than `change+1`
       *        - then we simply return `change+1` because, that will be the minimum change we won't be able to make
       *        - Explanation
       *            - for input [1,1,1,1,1], the minimum amount of change we can not create is 6.
       *            - because we can create change up to  5.
       *            - but we can not create the change of 6.
       *            - That's why
       *                - if we iterate through the array without finding the next element, which is greater than `change+1`
       *                - then we simply return `change+1` because, that will be the minimum change we won't be able to make
       *
       *
       *    - Time complexity  : O(n log(n)), where n is the length of the Array
       *    - space complexity : O(1), we are assuming that java uses in place array sorting and we are not using any kind of array to do our calculation.
       * */

        System.out.println(nonConstructibleChange(new int[]{5,7,1,1,2,3,22}));  // Expected Output: 20
        System.out.println(nonConstructibleChange(new int[]{5,7,2,3,22}));      // Expected Output: 1
        System.out.println(nonConstructibleChange(new int[]{1,1,1,1,1}));       // Expected Output: 6
    }

    public static int nonConstructibleChange(int[] coins){

        //sort the Array
        Arrays.sort(coins);
        int change = 0;

        if(coins.length ==0)
            return 1;

        for(int i=0; i<coins.length; i++){

           if(change+1 < coins[i])
               return change+1;

           change = change + coins[i];
        }
        return change+1;
    }
}
