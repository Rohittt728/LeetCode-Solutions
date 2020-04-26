/*

Link : https://leetcode.com/problems/merge-intervals/

Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

*/


class Solution {
    public int[][] merge(int[][] intervals) {
        
        Collections.sort(Arrays.asList(intervals), new Comparator<int[]>() {
            @Override
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }
        });
        
        List<int[]> list = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            
            int size = list.size();
            if (size == 0 || list.get(size - 1)[1] < interval[0])
                list.add(interval);
            else
                list.get(size - 1)[1] = Math.max(list.get(size - 1)[1], interval[1]);
        }
        
        return list.toArray(new int[list.size()][]);
    }
}