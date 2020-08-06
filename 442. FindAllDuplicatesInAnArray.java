/*

Link : https://leetcode.com/problems/find-all-duplicates-in-an-array/

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

*/



class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        
        for (int n : nums) {
            int i = Math.abs(n);
            
            if (nums[i - 1] < 0)
                ans.add(Math.abs(n));
            
            nums[i - 1] = -nums[i - 1];
        }
        return ans;
    }
}