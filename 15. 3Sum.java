/*

Link : https://leetcode.com/problems/3sum/

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
The solution set must not contain duplicate triplets.

Example:
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        int len = nums.length;
        if (len == 0)
            return ans;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])		// to avoid duplicate triplets
                continue;
            
            int j = i + 1;
            int k = len - 1;
            int sum = 0 - nums[i];
            while (j < k) {
                int curr = nums[j] + nums[k];
                if (curr == sum) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    while (j < k && nums[j] == nums[j + 1])		// to avoid duplicate triplets
                        j ++;
                    while (j < k && nums[k - 1] == nums[k])		// to avoid duplicate triplets
                        k --;
                    j ++;
                    k --;
                }
                else if (curr < sum)
                    j ++;
                else if (curr > sum)
                    k --;
            }
        }
        return ans;
    }
}