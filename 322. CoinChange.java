/*

Link : https://leetcode.com/problems/coin-change/

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Note:
You may assume that you have an infinite number of each kind of coin.

*/



// Solution 1 : Top Down DP
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        return coinChangeTopDown(coins, amount, new int[amount]);
    }
    
    public int coinChangeTopDown(int coins[], int amt, int dp[]) {
        
        if (amt == 0)
            return 0;
        
        if (dp[amt - 1] != 0)
            return dp[amt - 1];
        
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amt)
                continue;
            int val = coinChangeTopDown(coins, amt - coin, dp);
            if (val >= 0 && val < min)
                min = 1 + val;
        }
        dp[amt - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amt - 1];
    }
}



// Solution 2 : Bottom Up DP
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int max = amount + 1;
        int dp[] = new int[max];
        Arrays.fill(dp, max);
        
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}