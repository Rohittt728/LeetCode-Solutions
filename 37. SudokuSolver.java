/*

Link : https://leetcode.com/problems/sudoku-solver/

Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Example 1:
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:

Constraints:
board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.

*/


class Solution {
    public void solveSudoku(char[][] board) {
        solve(0, 0, board);
    }
    
    public boolean isValid(char board[][], int row, int col, char n) {
        // check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == n)
                return false;
        }
        // check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == n)
                return false;
        }
        // check 3*3 box
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == n)
                    return false;
            }
        }
        return true;
    }
    
    public boolean solve(int row, int col, char board[][]) {
        if (row == 9)
            return true;
        
        if (col == 9)
            return solve(row + 1, 0, board);
        
        if (board[row][col] == '.') {
            for (char c = '1'; c <= '9'; c++) {
                if (isValid(board, row, col, c)) {
                    board[row][col] = c;
                    if (solve(row, col + 1, board))
                        return true;
                    else
                        board[row][col] = '.';
                }
                else
                    board[row][col] = '.';
            }
        }
        else
            return solve(row, col + 1, board);
        return false;
    }
}