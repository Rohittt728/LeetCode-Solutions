/*

Link : https://leetcode.com/problems/n-queens/

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]

Constraints:
1 <= n <= 9

*/


class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        placeQueens(0, new int[n], ans, n);
        return ans;
    }
    
    public void placeQueens(int row, int cols[], List<List<String>> ans, int n) {
        if (row == n) {
            addResult(n, cols, ans);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (checkValid(cols, row, col)) {
                cols[row] = col;
                placeQueens(row + 1, cols, ans, n);
            }
        }
    }
    
    public boolean checkValid(int cols[], int row1, int col1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int col2 = cols[row2];
            
            // same column
            if (col2 == col1)
                return false;
            // check for same diagonal
            int colDist = Math.abs(col1 - col2);
            int rowDist = row1 - row2;
            if (colDist == rowDist)
                return false;
        }
        return true;
    }
    
    public void addResult(int n, int cols[], List<List<String>> ans) {
        List<String> list = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            int col = cols[row];
            
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == col)
                    sb.append("Q");
                else
                    sb.append(".");
            }
            list.add(sb.toString());
        }
        ans.add(list);
    }
}