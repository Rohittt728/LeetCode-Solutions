/*

Link : https://leetcode.com/problems/subarray-sum-equals-k/

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

*/


// Solution 1
class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k)
                    ans ++;
            }
        }
        return ans;
    }
}


// Solution 2
class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        h.put(0, 1);
        
        int ans = 0;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            if (h.containsKey(sum - k))
                ans += h.get(sum - k);
            h.put(sum, h.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}

