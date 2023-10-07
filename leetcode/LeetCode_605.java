package com.ronok.leetcode;

public class LeetCode_605 {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1},1)); // true
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1},2)); // false
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1,0,1},2)); // false
        System.out.println(canPlaceFlowers(new int[]{1,0,1,0,1,0,1},0)); // true
        System.out.println(canPlaceFlowers(new int[]{0,0,1,0,1},1)); // true
        System.out.println(canPlaceFlowers(new int[]{0,0,1,0,0},2)); // true
        System.out.println(canPlaceFlowers(new int[]{0},1)); // true
        System.out.println(canPlaceFlowers(new int[]{1},0)); // true
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,0,1},2)); // false
        System.out.println(canPlaceFlowers(new int[]{0,0},2)); // false
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i <= flowerbed.length - 1; i++) {

            if (flowerbed[i] == 0) {

                /*
                * we are checking if we are at the first element OR the element before us is ZERO
                * if it's not the first element that means it is second or third or forth element
                *
                * we are also checking if we are at the last element OR the element after us is ZERO
                * if it's not the last element that means it has some more element after this.
                *
                * and lastly if these conditions are met then we are trying to count how many flower we can place
                * */

                if( (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)){
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        return count >= n;
    }
}

