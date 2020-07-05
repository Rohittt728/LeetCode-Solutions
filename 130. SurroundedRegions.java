/*

Link : https://leetcode.com/problems/surrounded-regions/

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

Explanation:
Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

*/




class Solution {
    
    int m, n;
    public void solve(char[][] board) {
        
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        
        m = board.length;
        n = board[0].length;
        
        // first row
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);
        }
        
        // last column
        for (int i = 1; i < m - 1; i++) {
            if (board[i][n - 1] == 'O')
                dfs(board, i, n - 1);
        }
        
        // last row
        for (int j = 0; j < n; j++) {
            if (board[m - 1][j] == 'O')
                dfs(board, m - 1, j);
        }
        
        // first column
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    
    public void dfs(char board[][], int i, int j) {
        
        Queue<int[]> hq = new LinkedList<int[]>();
        int arr[] = new int[]{i, j};
        hq.add(arr);
        board[i][j] = '#';
        
        while (!hq.isEmpty()) {
            int temp[] = hq.poll();
            int p = temp[0];
            int q = temp[1];
            
            // top
            if (p - 1 >= 0 && board[p - 1][q] == 'O') {
                board[p - 1][q] = '#';
                hq.add(new int[]{p - 1, q});
            }
            
            // right
            if (q + 1 < n && board[p][q + 1] == 'O') {
                board[p][q + 1] = '#';
                hq.add(new int[]{p, q + 1});
            }
            
            // down
            if (p + 1 < m && board[p + 1][q] == 'O') {
                board[p + 1][q] = '#';
                hq.add(new int[]{p + 1, q});
            }
            
            // left
            if (q - 1 >= 0 && board[p][q - 1] == 'O') {
                board[p][q - 1] = '#';
                hq.add(new int[]{p, q - 1});
            }
        }
    }
}