package com.nitrous.leetcode.blind75.array.stock;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * @author nitrousdigital
 *
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1 ; i < prices.length; i++) {
            int price = prices[i];
            if (price < minPrice) {
                minPrice = price;
            } else if (price > minPrice) {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
