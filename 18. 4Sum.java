/*

Link : https://leetcode.com/problems/4sum/

Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Notice that the solution set must not contain duplicate quadruplets.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [], target = 0
Output: []

Constraints:
0 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109

*/


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0)
            return ans;
        
        int len = nums.length;
        Arrays.sort(nums);
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                
                int newTarget = target - nums[i] - nums[j];
                int front = j + 1;
                int back = len - 1;
                
                while (front < back) {
                    int twoSum = nums[front] + nums[back];
                    
                    if (twoSum < newTarget)
                        front++;
                    else if (twoSum > newTarget)
                        back--;
                    else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        ans.add(quad);
                        
                        while (front < back && nums[front] == quad.get(2))
                            front++;
                        while (front < back && nums[back] == quad.get(3))
                            back--;
                    }
                }
                while (j + 1 < len && nums[j] == nums[j + 1])
                    j++;
            }
            while (i + 1 < len && nums[i] == nums[i + 1])
                i++;
        }
        return ans;
    }
}