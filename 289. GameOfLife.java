/*

Link : https://leetcode.com/problems/game-of-life/

According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:
Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

Follow up:
1. Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
2. In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

*/



class Solution {
    public void gameOfLife(int[][] board) {
        
        // to handle 8 neighbours
        int neighbour[] = {0, 1, -1};
        
        int rows = board.length;
        int cols = board[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                // live neighbour count
                int n = 0;
                
                // getting live neighbours count
                for (int p = 0; p < 3; p++) {
                    for (int q = 0; q < 3; q++) {
                        if (!(neighbour[p] == 0 && neighbour[q] == 0)) {
                            int r = i + neighbour[p];
                            int c = j + neighbour[q];
                            
                            if ((r >= 0 && r < rows) && (c >= 0 && c < cols) && Math.abs(board[r][c]) == 1)
                                n += 1;
                        }
                    }
                }
                
                // using the rules given to modify the array
                if (board[i][j] == 1 && (n < 2 || n > 3))
                    board[i][j] = -1;
                if (board[i][j] == 0 && n == 3)
                    board[i][j] = 2;
            }
        }
        
        // getting final array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] > 0)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
    }
}