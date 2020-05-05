/*

Link : https://leetcode.com/problems/maximal-square/

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:
Input: 
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

*/


// Solution 1
class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int row = matrix.length;
        if (row == 0)
            return 0;
        int col = matrix[0].length;
        
        int dp[][] = new int[row][col];
        int max = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = matrix[i][j] - '0';
                else if (matrix[i][j] == '1')
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}



// Solution 2
class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int row = matrix.length;
        if (row == 0)
            return 0;
        int col = matrix[0].length;
        
        int dp[] = new int[col];
        int max = 0;
        
        int prev = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = dp[j];
                if (i == 0 || j == 0)
                    dp[j] = matrix[i][j] - '0';
                else if (matrix[i][j] == '1')
                    dp[j] = Math.min(Math.min(prev, dp[j]), dp[j - 1]) + 1;
                else
                    dp[j] = 0;
                max = Math.max(max, dp[j]);
                prev = temp;
            }
        }
        return max * max;
    }
}