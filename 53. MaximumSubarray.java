/*

Link : https://leetcode.com/problems/maximum-subarray/

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up: 
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

*/

// Solution 1
class Solution1 {
    // Kadane's Algorithm 
    public int maxSubArray(int[] nums) {
        int cur_max = nums[0];
        int max = nums[0];
        int l = nums.length;
        
        for (int i = 1; i < l; i++) {
            cur_max = Math.max(cur_max + nums[i], nums[i]);
            max = Math.max(cur_max, max);
        }
        return max;
    }
}


// Solution 2
class Solution2 {
    // Divide and Conquer approach
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int l = 0;
        int h = n-1;
        return maxSubArraySum(nums, n, l, h);
    }
    
    public int maxSubArraySum(int nums[], int n, int l, int h) {
        if (l == h)
            return nums[l];
        int m = (l + h) / 2;
        int left_sum = maxSubArraySum(nums, n, l, m);
        int right_sum = maxSubArraySum(nums, n, m + 1, h);
        
        int sum = 0;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        
        for (int i = m+1; i <= h; i++) {
            sum = sum + nums[i];
            right = Math.max(sum, right);
        }
        sum = 0;
        for (int i = m; i >= l; i--) {
            sum = sum + nums[i];
            left = Math.max(sum, left);
        }
        
        int max = Math.max(left_sum, right_sum);
        return Math.max(max, left+right);
    }
}