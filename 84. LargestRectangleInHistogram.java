/*

Link : https://leetcode.com/problems/largest-rectangle-in-histogram/

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Example:
Input: [2,1,5,6,2,3]
Output: 10

*/

class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null)
            return 0;
        int l = height.length;
        if (l == 0)
            return 0;
        Stack<Integer> st = new Stack<Integer>();
        int max_area = Integer.MIN_VALUE;
        int index = 0, area = 0;
        int i = 0;
        for (i = 0; i < l;) {
            if (st.isEmpty() || height[st.peek()] <= height[i]) {
                st.push(i++);
            }
            else {
                index = st.pop();
                area = height[index] * (st.isEmpty() ? i : (i - st.peek() - 1));
                if (area > max_area) {
                    max_area = area;
                }
            }
        }
        while (!st.isEmpty()) {
            index = st.pop();
            area = height[index] * (st.isEmpty() ? i : (i - st.peek() - 1));
            if (area > max_area) {
                max_area = area;
            }
        }
        return max_area;
    }
}