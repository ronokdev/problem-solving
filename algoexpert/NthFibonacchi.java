package com.ronok.algoexpert;

public class NthFibonacchi {
    public static void main(String[] args){
        System.out.println(doNthFibonacci(1)); // Expected output : 0
        System.out.println(doNthFibonacci(2)); // Expected output : 1
        System.out.println(doNthFibonacci(6)); // Expected output : 5
    }

    private static int doNthFibonacci(int param) {
        /*
        * Steps
        *   - we can use TWO pointer in order to calculate the Nth Fib
        *
        *   - Time Complexity : O(n) where n is the param in doNthFibonacci
        *   - Space Complexity : O(1)
        * */

        int f1 =0;
        int f2 =1;
        int res = f1+f2;

        if(param <= 2){
            int base = param == 2 ? 1 : 0;
            return base;
        }

        while(param > 3){
            f1 = f2;
            f2 = res;
            res = f1+f2;
            param--;
        }
        return res;
    }
}