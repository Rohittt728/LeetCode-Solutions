/*

Link : https://leetcode.com/problems/subsets/

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/


// Solution1 : Recursive
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int len = nums.length;
        
        if (len == 0)
            return ans;
        
        getSubsets(nums, ans, 0, len, new ArrayList<Integer>());
        return ans;
    }
    
    public void getSubsets(int nums[], List<List<Integer>> ans, int start, int len, ArrayList<Integer> temp) {
        
        ans.add(new ArrayList<Integer>(temp));
        
        for (int i = start; i < len; i++) {
            temp.add(nums[i]);
            getSubsets(nums, ans, i + 1, len, temp);
            temp.remove(temp.size() - 1);
        }
    }
}


// Solution2 : Iterative
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        
        for (int i : nums) {
            
            List<List<Integer>> curr = new ArrayList<List<Integer>>();
            
            for (List<Integer> list : ans)
                curr.add(new ArrayList<Integer>(list){{add(i);}});
            
            for (List<Integer> list : curr)
                ans.add(list);
        }
        
        return ans;
    }
}



// Solution3 : using bitmask
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        int n = nums.length;
        
        int start = (int)Math.pow(2, n);
        int end = (int)Math.pow(2, n + 1);
        for (int i = start; i < end; i++) {
            String bitmask = Integer.toBinaryString(i).substring(1);
            
            int len = bitmask.length();
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < len; j++) {
                char ch = bitmask.charAt(j);
                if (ch == '1')
                    temp.add(nums[j]);
            }
            ans.add(temp);
        }
        return ans;
    }
}