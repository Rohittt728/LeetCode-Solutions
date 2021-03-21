/*

Link : https://leetcode.com/problems/rotting-oranges/

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.

*/


class Solution {
    public int orangesRotting(int[][] grid) {
        
        // empty/null cases
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        int freshOranges = 0;
        
        // counting current fresh oranges & add rotten to queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1)
                    freshOranges++;
                
                if (grid[i][j] == 2)
                    q.add(new int[]{i, j});
            }
        }
        
        int days = 0;
        int dirs[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // doing BFS on queue (sort of level order traversal on a BT)
        while (!q.isEmpty() && freshOranges > 0) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int temp[] = q.poll();
                
                for (int j = 0; j < 4; j++) {
                    int x = temp[0] + dirs[j][0];
                    int y = temp[1] + dirs[j][1];
                    
                    // boundary cases & if the grid value is not a fresh orange
                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    
                    grid[x][y] = 2;
                    freshOranges--;
                    q.add(new int[]{x, y});
                }
            }
            // incrementing days by 1
            days++;
        }
        // if no freshoranges then days else -1
        return freshOranges == 0 ? days : -1;
    }
}