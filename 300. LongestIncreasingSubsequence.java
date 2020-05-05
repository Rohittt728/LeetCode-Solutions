/*

Link : https://leetcode.com/problems/longest-increasing-subsequence/

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Note:
There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

*/


// Solution 1 : Brute Force Recursion
class Solution {
    public int lengthOfLIS(int[] nums) {
        return lengthLIS(nums, Integer.MIN_VALUE, 0);
    }
    
    public int lengthLIS(int nums[], int prev, int curr) {
        if (curr == nums.length)
            return 0;
        
        int taken = 0;
        if (nums[curr] > prev)
            taken = 1 + lengthLIS(nums, nums[curr], curr + 1);
        int nottaken = lengthLIS(nums, prev, curr + 1);
        
        return Math.max(taken, nottaken);
    }
}


// Solution 2 : Recursive DP on brute force (memoization)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int dp[][] = new int[len + 1][len];
        for (int a[] : dp)
            Arrays.fill(a, -1);
        return lengthLIS(nums, -1, 0, dp);
    }
    
    public int lengthLIS(int nums[], int prev, int curr, int dp[][]) {
        if (curr == nums.length)
            return 0;
        
        if (dp[prev + 1][curr] >= 0)
            return dp[prev + 1][curr];
        
        int taken = 0;
        if (prev < 0 || nums[curr] > nums[prev])
            taken = 1 + lengthLIS(nums, curr, curr + 1, dp);
        int nottaken = lengthLIS(nums, prev, curr + 1, dp);
        
        dp[prev + 1][curr] = Math.max(taken, nottaken);
        
        return dp[prev + 1][curr];
    }
}


// Solution 3 : DP Iterative (1D DP array), TC: O(n^2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        
        int dp[] = new int[len];
        dp[0] = 1;
        int ans = 1;
        
        for (int i = 1; i < len; i++) {
            int ival = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    ival = Math.max(ival, dp[j]);
            }
            dp[i] = ival + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}



// Solution 4 : DP, TC : O(nlogn), using binary search in the DP array
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        
        int dp[] = new int[len];
        len = 0;
        
        for (int n : nums) {
            int i = Arrays.binarySearch(dp, 0, len, n);
            System.out.println (i + " " + len);
            if (i < 0)
                i = -(i + 1);
            
            dp[i] = n;
            if (i == len)
                len ++;
        }
        return len;
    }
}