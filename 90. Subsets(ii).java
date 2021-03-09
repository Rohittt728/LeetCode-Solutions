/*

Link : https://leetcode.com/problems/subsets-ii/

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10

*/


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        subsets(nums, 0, ans, new ArrayList<Integer>());
        return ans;
    }
    
    public void subsets(int nums[], int start, List<List<Integer>> ans, List<Integer> temp) {
        
        ans.add(new ArrayList<Integer>(temp));
        if (start >= nums.length)
            return;
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            
            temp.add(nums[i]);
            subsets(nums, i + 1, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}