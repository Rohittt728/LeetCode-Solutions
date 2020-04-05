/*

Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

Example 2:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

*/


// Solution 1
class Solution {
	// Brute Force approach O(n^2)
    public int maxProfit(int[] prices) {
        int l = prices.length;
        int max_profit = 0;
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                max_profit = Math.max (max_profit, prices[j] - prices[i]);
            }
        }
        return max_profit;
    }
}


// Solution 2
class Solution {
	// One pass solution O(n)
    public int maxProfit(int[] prices) {
        int l = prices.length;
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int i = 0; i < l; i++) {
            min_price = Math.min(min_price, prices[i]);
            max_profit = Math.max(max_profit, prices[i] - min_price);
        }
        return max_profit;
    }
}