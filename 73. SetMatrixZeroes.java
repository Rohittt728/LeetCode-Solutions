/*

Link : https://leetcode.com/problems/set-matrix-zeroes/

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:
Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Example 2:
Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]

Follow up:
-- A straight forward solution using O(mn) space is probably a bad idea.
-- A simple improvement uses O(m + n) space, but still not the best solution.
-- Could you devise a constant space solution?

*/


// Solution 1
class Solution {
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // first row zero check
        int fRow = 1;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0)
                fRow = 0;
        }
        
        // first column zero check
        int fCol = 1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)
                fCol = 0;
        }
        
        // moving all zeroes to first row & first column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // making row wise zero according to first column zero data. avoiding first row
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++)
                    matrix[i][j] = 0;
            }
        }
        
        // making column wise zero according to first row zero data. avoiding first column
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++)
                    matrix[j][i] = 0;
            }
        }
        
        // handling first row
        if (fRow == 0) {
            for (int i = 0; i < n; i++)
                matrix[0][i] = 0;
        }
        
        // handling first column
        if (fCol == 0) {
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }
}


// Solution 2 : Better approach
class Solution {
    public void setZeroes(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        int fcol = 1;
        
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0)
                fcol = 0;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (fcol == 0)
                matrix[i][0] = 0;
        }
    }
}