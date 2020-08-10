package com.leetcode.top75.Arrays;

public class buySellStock {
    public static void main(String[] args){
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println("Max Profit: "+ maxProfit(prices));
    }
    private static int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit =0;
        for(int price : prices){
            if(price<minPrice)
                minPrice=price;
            else if(price-minPrice>maxProfit)
                maxProfit=price-minPrice;
        }
        return maxProfit;
    }
}

