/*

Link : https://leetcode.com/problems/perfect-squares/

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:
Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

*/



class Solution {
    public int numSquares(int n) {
        
        if (n <= 0)
            return 0;
        
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int x = (int)Math.sqrt(i);
            x = x * x;
            if (x == i)
                dp[i] = 1;
            else {
                for (int j = 1; j *j <= i; j++) {
                    int y = j * j;
                    dp[i] = Math.min(dp[i], dp[i - y] + dp[y]);
                }
            }
        }
        return dp[n];
    }
}