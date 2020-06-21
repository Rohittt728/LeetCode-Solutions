/*

Link : https://leetcode.com/problems/largest-divisible-subset/

Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:
Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)

Example 2:
Input: [1,2,4,8]
Output: [1,2,4,8]

*/



class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        // Step 1 : Sort the array
        Arrays.sort(nums);
        
        // Step 2 : Apply LIS concept and get max length DP array
        int len = nums.length;
        int dp[] = new int[len];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        
        // Step 3 : Getting one of the valid subsets using the DP array
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int prev = -1;
        
        for (int j = len - 1; j >= 0; j--) {
            if (dp[j] == maxLen && (prev == -1 || prev % nums[j] == 0)) {
                ans.add(nums[j]);
                maxLen --;
                prev = nums[j];
                if (maxLen == 0)
                    break;
            }
        }
        
        return ans;
    }
}