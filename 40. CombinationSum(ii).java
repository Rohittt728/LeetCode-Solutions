/*

Link : https://leetcode.com/problems/combination-sum-ii/

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]

Constraints:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

*/


// Recursion, Backtracking
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinations(candidates, target, 0, ans, new ArrayList<Integer>());
        return ans;
    }
    
    public void combinations(int cand[], int target, int start, List<List<Integer>> ans, List<Integer> temp) {
        
        if (target == 0) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        if (target < 0 || start >= cand.length)
            return;
        
        for (int i = start; i < cand.length; i++) {
            if (i > start && cand[i] == cand[i - 1])
                continue;
            temp.add(cand[i]);
            combinations(cand, target - cand[i], i+1, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}