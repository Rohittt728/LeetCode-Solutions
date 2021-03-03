/*

Link : https://leetcode.com/problems/unique-paths/

A robot is located at the top-left corner of a m x n grid.

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.

How many possible unique paths are there?

Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:
Input: m = 7, n = 3
Output: 28

Constraints:
1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.

*/



// Solution 1 : DP (2D)
class Solution {
    public int uniquePaths(int m, int n) {
        
        int dp[][] = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}



// Solution 2 : DP (1D)
class Solution {
    public int uniquePaths(int m, int n) {
        
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}


// Solution 3 : Most Optimal
class Solution {
    public int uniquePaths(int m, int n) {
        
        int p = m + n - 2;
        int r = m - 1;
        double ans = 1;
        
        for (int i = 1; i <= r; i++) {
            ans = ans * (p - r + i) / i;
        }
        
        return (int)ans;
    }
}