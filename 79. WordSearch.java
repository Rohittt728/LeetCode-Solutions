/*

Link : https://leetcode.com/problems/word-search/

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

Constraints:
board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3

*/


// Solution1 : Using a separate visited array
class Solution {
    int m, n, len;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        len = word.length();
        
        int i = 0, j = 0;
        boolean visited[][] = new boolean[m][n];
        
        boolean f = false;
        for (int p = 0; p < m; p ++) {
            for (int q = 0; q < n; q ++) {
                if (board[p][q] == word.charAt(0)) {
                    f = check(board, word, visited, p, q);
                }
                if (f)
                    return f;
            }
        }
        return f;
    }
    
    public boolean check(char board[][], String word, boolean visited[][], int i, int j) {
        
        if (word.length() == 0)
            return true;
        
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || word.charAt(0) != board[i][j])
            return false;
        
        visited[i][j] = true;
        
        if (check(board, word.substring(1), visited, i - 1, j) || check(board, word.substring(1), visited, i + 1, j) || check(board, word.substring(1), visited, i, j - 1) || check(board, word.substring(1), visited, i, j + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}



// Solution2 : without using a separate visited array
class Solution {
    int m, n, len;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        len = word.length();
        
        int i = 0, j = 0;
        
        boolean f = false;
        for (int p = 0; p < m; p ++) {
            for (int q = 0; q < n; q ++) {
                if (board[p][q] == word.charAt(0)) {
                    f = check(board, word, p, q);
                }
                if (f)
                    return f;
            }
        }
        return f;
    }
    
    public boolean check(char board[][], String word, int i, int j) {
        
        if (word.length() == 0)
            return true;
        
        if (i < 0 || j < 0 || i >= m || j >= n || word.charAt(0) != board[i][j])
            return false;
        
        char ch = board[i][j];
        board[i][j] = '#';
        
        if (check(board, word.substring(1), i - 1, j) || check(board, word.substring(1), i + 1, j) || check(board, word.substring(1), i, j - 1) || check(board, word.substring(1), i, j + 1)) {
            return true;
        }
        board[i][j] = ch;
        return false;
    }
}