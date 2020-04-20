/*

Link : https://leetcode.com/problems/permutations/

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/



class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        int len = nums.length;
        if (len == 0)
            return ans;
        
        getPermutations(nums, 0, len, ans);
        return ans;
    }
    
    public void getPermutations(int nums[], int start, int end, List<List<Integer>> ans) {
        
        if (start == end)
            ans.add(getList(nums));
        else {
            for (int i = start; i < end; i++) {
                swap(nums, start, i);
                getPermutations(nums, start + 1, end, ans);
                swap(nums, start, i);
            }
        }
            
    }
    
    public void swap(int nums[], int i, int j) {
        int p = nums[i];
        nums[i] = nums[j];
        nums[j] = p;
    }
    
    public List<Integer> getList(int nums[]) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : nums)
            list.add(i);
        return list;
    }
}