/*

Link : https://leetcode.com/problems/trapping-rain-water/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105

*/


// Solution 1 : Using Stack (Brute Force)
class Solution {
    public int trap(int[] height) {
        
        if (height == null || height.length <= 1)
            return 0;
        
        int len = height.length;
        int ans = 0, start = height[0];
        
        Stack<Integer> st = new Stack<Integer>();
        st.push(start);
        
        for (int i = 1; i < len; i++) {
            
            if (st.isEmpty() || start > height[i])
                st.push(height[i]);
            
            else {
                int count = 0;
                while (!st.isEmpty()) {
                    count ++;
                    ans = ans - st.pop();
                }
                ans = ans + (start * count);
                st.push(height[i]);
                start = height[i];
            }
        }
        
        while (!st.isEmpty() && st.size() > 1) {
            int ele = st.pop(); //2
            int count = 0;
            while (!st.isEmpty() && ele > st.peek()) {
                ans = ans - st.pop();
                count++; // 1
            }
            
            int top = st.peek(); // 2
            ans += count * (Math.min(top, ele));
        }
        
        return ans;
    }
}


// Solution 2 : Two pointers (Most Optimal)
class Solution {
    public int trap(int[] height) {
        
        if (height == null || height.length == 0)
            return 0;
        
        int len = height.length;
        int leftmax = 0, rightmax = 0;
        int i = 0, j = len - 1, ans = 0;
        
        while (i <= j) {
            if (height[i] <= height[j]) {
                if (height[i] >= leftmax)
                    leftmax = height[i];
                else
                    ans += leftmax - height[i];
                i++;
            }
            
            else {
                if (height[j] >= rightmax)
                    rightmax = height[j];
                else
                    ans += rightmax - height[j];
                j--;    
            }
        }
        return ans;
    }
}