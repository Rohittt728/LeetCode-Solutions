/*

Link : https://leetcode.com/problems/island-perimeter/

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:
Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:



*/



class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        int neighbours = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == 1) {
                        islands ++;
                    if (i + 1 < m && grid[i + 1][j] == 1)
                        neighbours ++;
                    if (j + 1 < n && grid[i][j + 1] == 1)
                        neighbours ++;
                }
            }
        }
        
        // minus 2 for each adjacent island
        return islands * 4 - neighbours * 2;
    }
}