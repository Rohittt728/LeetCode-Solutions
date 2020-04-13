/*

Link : https://leetcode.com/problems/house-robber/

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.

*/


// Solution1 : Typical DP solution
class Solution {
    public int rob(int[] nums) {
        if(nums == null)
            return 0;
        
        int len = nums.length;
        
        if (len == 0)
            return 0;
        if (len == 1)
            return nums[0];
        
        int dp[] = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i - 1]);
        }
        
        return dp[len - 1];
    }
}



// Solution2 : keeping track of even odd separately
class Solution {
    public int rob(int[] nums) {
        if(nums == null)
            return 0;
        
        int len = nums.length;
        
        if (len == 0)
            return 0;
        
        int even = 0, odd = 0;
        for (int i = 0; i < len; i++) {
            if ((i & 1) == 0) {
                even += nums[i];
                even = Math.max(even, odd);
            }
            else {
                odd += nums[i];
                odd = Math.max(even, odd);
            }
        }
        return Math.max(even, odd);
    }
}