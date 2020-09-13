/*

Link : https://leetcode.com/problems/combination-sum-iii/

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:
All numbers will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

*/



class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtrack(n, k, new ArrayList<Integer>(), 1, ans);
        return ans;
    }
    
    public void backtrack(int n, int k, List<Integer> temp, int next_i, List<List<Integer>> ans) {
        
        if (n == 0 && temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        else if (n < 0 || temp.size() == k)
            return;
        
        for (int i = next_i; i <= 9; i++) {
            temp.add(i);
            backtrack(n - i, k, temp, i + 1, ans);
            temp.remove(temp.size() - 1);
        }
    } 
}