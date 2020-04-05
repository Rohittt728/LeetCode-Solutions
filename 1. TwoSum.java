/*

Link : https://leetcode.com/problems/two-sum/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/

public int[] twoSum(int[] nums, int target) {
    int l = nums.length;
    HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();  // hashmap for search optimization
    for (int i = 0; i < l; i++) {
        int n = target - nums[i];               // n + nums[i] = target; search for 'n' instead
        if (h.containsKey(n)) {                 // reduced to Search problem
            return new int[] {h.get(n), i};
        }
        h.put (nums[i], i);                     // else populate hashmap
    }
    return null;
}