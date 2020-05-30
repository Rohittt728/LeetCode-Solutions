/*

Link : https://leetcode.com/problems/course-schedule/

There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.

Constraints:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5

*/



// Solution 1 : BFS
class Solution {
    public boolean canFinish(int num, int[][] pre) {
        
        if (num == 0 || pre.length == 0)
            return true;
        
        int len = pre.length;
        
        int indegree[] = new int[num];
        for (int i = 0; i < len; i++)
            indegree[pre[i][0]] ++;
        
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < num; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        
        int count = q.size();
        
        while (!q.isEmpty()) {
            int node = q.poll();
            
            for (int i = 0; i < len; i++) {
                if (pre[i][1] == node) {
                    indegree[pre[i][0]] --;
                    if (indegree[pre[i][0]] == 0) {
                        count ++;
                        q.add(pre[i][0]);
                    }
                }
            }
        }
        return count == num;
    }
}



// Solution 2 : DFS
class Solution {
    public boolean canFinish(int num, int[][] pre) {
        
        if (num == 0 || pre.length == 0)
            return true;
        
        HashMap<Integer, ArrayList<Integer>> h = new HashMap<Integer, ArrayList<Integer>>();
        
        int len = pre.length;
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> list = h.getOrDefault(pre[i][0], new ArrayList<Integer>());
            list.add(pre[i][1]);
            h.put(pre[i][0], list);
        }
        
        int visited[] = new int[num];
        for (int i = 0; i < num; i++) {
            if (!dfs(i, visited, h))
                return false;
        }
        
        return true;
    }
    
    public boolean dfs(int n, int visited[], HashMap<Integer, ArrayList<Integer>> h) {
        
        if (visited[n] == -1)
            return false;
        if (visited[n] == 1)
            return true;
            
        visited[n] = -1;
        
        if (h.containsKey(n)) {
            for (int i : h.get(n)) {
                if (!dfs(i, visited, h))
                    return false;
            }
        }
        
        visited[n] = 1;
        return true;
    }
}