/*

Link : https://leetcode.com/problems/valid-sudoku/

Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true

Example 2:
Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Note:
A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.

*/


class Solution {
    public boolean isValidSudoku(char[][] board) {

    	// Row wise check
        for (int i = 0; i < 9; i++) {
            int ch[] = new int[9];
            Arrays.fill(ch, 0);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] >= 49 && board[i][j] <= 57) {
                    ch[board[i][j] - '1']++;
                    if (ch[board[i][j] - '1'] > 1)
                        return false;
                }
            }
        }
        
        // Column wise check
        for (int i = 0; i < 9; i++) {
            int ch[] = new int[9];
            Arrays.fill(ch, 0);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] >= 49 && board[j][i] <= 57) {
                    ch[board[j][i] - '1']++;
                    if (ch[board[j][i] - '1'] > 1)
                        return false;
                }
            }
        }
        
        // 3x3 Matrix check
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValid(board, i, j))
                    return false;
            }
        }
        return true;
    }
    
    public boolean isValid (char board[][], int r, int c) {
        HashSet<Character> h = new HashSet<Character>();
        for (int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                if (board[i][j] >= 49 && board[i][j] <= 57) {
                    if (h.contains(board[i][j]))
                        return false;
                    h.add(board[i][j]);
                }
            }
        }
        return true;
    }
}