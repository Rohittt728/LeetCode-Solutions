/*

Link : https://leetcode.com/problems/contiguous-array/

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000.

*/


class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        int len = nums.length;
        
        int count = 0;
        int max = 0;
        h.put(0, -1);
        
        for (int i = 0; i < len; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if (!h.containsKey(count))
                h.put(count, i);
            else
                max = Math.max(max, i - h.get(count));
        }
        return max;
    }
}