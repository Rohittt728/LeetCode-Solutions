/*

Link : https://leetcode.com/problems/jump-game/

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.

Example 1:
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.

*/



// Solution 1 : Bottom Up DP
class Solution {
    public boolean canJump(int[] nums) {
        
        int len = nums.length;
        boolean dp[] = new boolean[len];
        
        dp[len - 1] = true;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i; j <= i + nums[i] && j < len; j++) {
                if (dp[j] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}



// Solution 2 : O(1) space
class Solution {
    public boolean canJump(int[] nums) {
        
        int len = nums.length;
        int lastReach = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (i + nums[i] >= lastReach)
                lastReach = i;
        }
        return lastReach == 0;
    }
}
