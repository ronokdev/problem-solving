package com.ronok.algoexpert;

import java.util.Arrays;

public class SortedSquaredArray {
    public static void main(String[] args){
        System.out.println(Arrays.toString(sortedSquaredArray(new int[]{1,2,3,4,5,6,7,8,9}))); // Expected Output: [1, 4, 9, 16, 25, 36, 49, 64, 81]
        System.out.println(Arrays.toString(sortedSquaredArray(new int[]{-9,-8,-7})));          // Expected Output: [49, 64, 81]
        System.out.println(Arrays.toString(sortedSquaredArray(new int[]{-3,-2,-1,0,1,2,3})));  // Expected Output: [0, 1, 1, 4, 4, 9, 9]
    }

    public static int[] sortedSquaredArray(int[] array) {

        /*
        * Steps
        *   - we will use two pointer method
        *   - we will apply the two pointer to the `array` variable
        *   - first pointer will start at the start of the array variable
        *   - second pointer will start at the end of the array variable
        *
        *   - Then we will check which one's square is Greater, and we will store the square of that value into our new array `resultArray`
        *   - and we will continue this until the first pointer is small or equal to the second pointer
        * */


        int[] resultArray = new int[array.length];
        int firstPointer= 0;                // first value of the array
        int secondPointer = array.length-1; // last value of the Array
        int j = array.length-1;
        int value1;
        int value2;

        while(firstPointer <= secondPointer){

            value1 = array[firstPointer];
            value2 = array[secondPointer];

            if(value1*value1 >= value2*value2){
                resultArray[j--] = value1*value1;
                firstPointer++;
            }
            else{
                resultArray[j--] = value2*value2;
                secondPointer--;
            }
        }
        return resultArray;
        }
    }