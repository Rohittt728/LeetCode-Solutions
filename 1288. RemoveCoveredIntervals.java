/*

Link : https://leetcode.com/problems/remove-covered-intervals/

Given a list of intervals, remove all intervals that are covered by another interval in the list.

Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
After doing so, return the number of remaining intervals.

Example 1:
Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.

Example 2:
Input: intervals = [[1,4],[2,3]]
Output: 1

Example 3:
Input: intervals = [[0,10],[5,12]]
Output: 2

Example 4:
Input: intervals = [[3,10],[4,10],[5,11]]
Output: 2

Example 5:
Input: intervals = [[1,2],[1,4],[3,4]]
Output: 1

Constraints:
1 <= intervals.length <= 1000
intervals[i].length == 2
0 <= intervals[i][0] < intervals[i][1] <= 10^5
All the intervals are unique.

*/


// Solution 1 : Brute Force
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        int len = intervals.length;
        int count = len;
        
        for (int i = 0; i < len; i++) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            for (int j = 0; j < len; j++) {
                if (i == j)
                    continue;
                
                if (a >= intervals[j][0] && b <= intervals[j][1]) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}


// Solution 2 : Sorting
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> ((a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0])));
        
        int temp = 0;
        int ans = 0;
        for (int arr[] : intervals) {
            if (temp < arr[1]) {
                temp = arr[1];
                ans++;
            }
        }
        return ans;
    }
}