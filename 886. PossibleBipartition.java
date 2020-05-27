/*

Link : https://leetcode.com/problems/possible-bipartition/

Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

Example 1:
Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]

Example 2:
Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false

Example 3:
Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false

Note:
1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].

*/



// Solution 1 : DFS
class Solution {
    
    ArrayList<Integer>[] graph;
    HashMap<Integer, Integer> color;
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        
        for (int edge[] : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        color = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (!color.containsKey(i) && !dfs(i, 0))
                return false;
        }
        return true;
    }
    
    public boolean dfs (int val, int c) {
        if (color.containsKey(val))
            return color.get(val) == c;
        
        color.put(val, c);
        for (int neighbour : graph[val]) {
            if (!dfs(neighbour, c ^ 1))
                return false;
        }
        return true;
    }
}


// Solution 2 : Union Find
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] colors = new int[N + 1];
        for(int i = 1; i <= N; ++i) colors[i] = i;
        for(int i = 0; i < dislikes.length; ++i) {
            int p1 = dislikes[i][0], p2 = dislikes[i][1];
            if(colors[p2] == p2) colors[p2] = p1;
            else {
                int[] uf1 = find(p1, colors), uf2 = find(p2, colors);
                if(uf1[0] == uf2[0] && uf1[1] == uf2[1]) return false;
            }
        }
        return true;
    }
    
    private int[] find(int p, int[] colors) {
        int color = 0;
        while(colors[p] != p) {
            p = colors[p];
            color = color == 0 ? 1 : 0;
        }
        return new int[] {p, color};
    }
}