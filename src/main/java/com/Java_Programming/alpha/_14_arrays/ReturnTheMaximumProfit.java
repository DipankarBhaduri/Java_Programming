package com.Java_Programming.alpha._14_arrays;

import java.util.Scanner;

public class ReturnTheMaximumProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int size = scanner.nextInt();
        int [] arr = new int[size];
        for ( int i = 0 ; i < size ; i++ ){
            arr[i] = scanner.nextInt() ;
        }
        int profit = ReturnTheMaximumProfitFromPrices(arr) ;
        System.out.println(profit);
    }
    public static int ReturnTheMaximumProfitFromPrices ( int [] arr ){
        int maxProfit = 0 ;
        int buyingPrice = Integer.MAX_VALUE ;
        for ( int i = 0 ; i < arr.length ; i++ ){
            int price = arr[i] ;
            buyingPrice = Math.min(buyingPrice, price);
            maxProfit = Math.max(maxProfit, price - buyingPrice) ;
        }
        return maxProfit ;
    }
}
