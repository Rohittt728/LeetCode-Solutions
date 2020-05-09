/*

Link : https://leetcode.com/problems/number-of-islands/

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000

Output: 1

Example 2:
Input:
11000
11000
00100
00011

Output: 3

*/



// Solution1 : Using DFS (recursive)
class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        
        boolean visited[][] = new boolean[m][n];	// keep track of visited 1's
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == '1' && !visited[i][j]) {
                    doDFS(grid, i, j, m, n, visited);		// DFS (depth first search)
                    ans ++;									// counting islands
                }
            }
        }
        return ans;
    }
    
    public void doDFS(char grid[][], int i, int j, int m, int n, boolean visited[][]) {
        
        int rowNbr[] = new int[] {-1, 0, 1, 0};		// horizontal & vertical neighbours
        int colNbr[] = new int[] {0, 1, 0, -1};
        
        visited[i][j] = true;
        
        for (int k = 0; k < 4; k++) {
            if (isSafe(grid, i + rowNbr[k], j + colNbr[k], m, n, visited))
                doDFS(grid, i + rowNbr[k], j + colNbr[k], m, n, visited);	// going in depth
        }
    }
    
    // if the index is within range, not visited yet, equal to 1
    public boolean isSafe(char grid[][], int i, int j, int m, int n, boolean visited[][]) {
        if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1' && !visited[i][j])
            return true;
        return false;
    }
}



// Solution 2 : Union-Find
class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        if (m == 0)
            return 0;
        
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m*n);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0')
                    continue;
                
                if (i - 1 >= 0 && grid[i - 1][j] == '1')
                    uf.union(n * i + j, ((i - 1) * n) + j);
                if (i + 1 < m && grid[i + 1][j] == '1')
                    uf.union(n * i + j, ((i + 1) * n) + j);
                if (j - 1 >= 0 && grid[i][j - 1] == '1')
                    uf.union(n * i + j, (i * n) + (j - 1));
                if (j + 1 < n && grid[i][j + 1] == '1')
                    uf.union(n * i + j, (i * n) + (j + 1));
            }
        }
        
        int freq[] = new int[m * n];
        int ans = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == '1') {
                    int f = uf.find(n * i + j);
                    
                    if (freq[f] == 0)
                        ans ++;
                    freq[f] ++;
                }
            }
        }
        return ans;
    }
}


class UnionFind {
    int rank[];
    int parent[];
    int n;
    
    public UnionFind(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }
    
    public void makeSet() {
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }
    
    public int find(int x) {
        if (parent[x] != x)
            return find(parent[x]);
        return x;
    }
    
    public void union(int x, int y) {
        int xP = find(x);
        int yP = find(y);
        
        if (xP == yP)
            return;
        if (rank[xP] < rank[yP])
            parent[xP] = yP;
        else if (rank[xP] > rank[yP])
            parent[yP] = xP; 
        else {
            parent[yP] = xP;
            rank[xP] = rank[xP] + 1;
        }
    }
}