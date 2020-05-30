/*

Link : https://leetcode.com/problems/k-closest-points-to-origin/

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

Note:
1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000

*/


// Solution 1 : Priority Queue
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int len = points.length;
        
        int p[] = new int[len];
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> p[x] - p[y]);
        
        for (int i = 0; i < len; i++) {
            p[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.add(i);
        }
        
        int ans[][] = new int[k][2];
        int i = 0;
        while (i < k) {
            int index = pq.poll();
            ans[i][0] = points[index][0];
            ans[i][1] = points[index][1];
            i ++;
        }
        
        return ans;
    }
}



// Solution 2 : Short code
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int len = points.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        
        for (int arr[] : points) {
           pq.add(arr);
        }
        
        int ans[][] = new int[k][2];
        int i = 0;
        while (i < k) {
            ans[i] = pq.poll();
            i ++;
        }
        
        return ans;
    }
}