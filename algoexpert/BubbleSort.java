package com.ronok.algoexpert;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        System.out.println(Arrays.toString(doBubbleSort(new int[]{8,5,2,8,5,6,3})));
        System.out.println(Arrays.toString(doBubbleSort(new int[]{-8,5,2,23,16,15})));
        System.out.println(Arrays.toString(doBubbleSort(new int[]{8,5,0,23,16,15})));
    }

    private static int[] doBubbleSort(int[] arr) {

        for(int i=0; i<arr.length; i++){
            int q =0;

            for(int j=0; j< arr.length-1-i ; j++){

                if(arr[j] > arr[j+1]){
                   q= arr[j+1] ;
                   arr[j+1] = arr[j];
                   arr[j] = q;
                }
            }
        }
        return arr;
    }
}