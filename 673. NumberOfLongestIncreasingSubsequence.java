/*

Link : https://leetcode.com/problems/number-of-longest-increasing-subsequence/

Given an integer array nums, return the number of longest increasing subsequences.

Example 1:
Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

Example 2:
Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.

Constraints:
0 <= nums.length <= 2000
-106 <= nums[i] <= 106

*/


class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int len = nums.length;
        
        if (len <= 1)
            return len;
        
        // length of longest ending int nums[i]
        int length[] = new int[len];
        // number of longest ending in nums[i]
        int count[] = new int[len];
        Arrays.fill(count, 1);
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                
                if (nums[i] > nums[j]) {
                    if (length[j] >= length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    }
                    else if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        
        int maxlen = 0;
        for (int i : length)
            maxlen = Math.max(i, maxlen);
        
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (length[i] == maxlen)
                ans += count[i];
        }
        
        return ans;
    }
}