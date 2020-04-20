/*

Link : https://leetcode.com/problems/generate-parentheses/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        if (n == 0)
            return ans;
        getCombinations(n, 0, 0, ans, "");
        return ans;
    }
    
    public void getCombinations(int n, int open, int close, List<String> ans, String curr) {
        if (curr.length() == 2 * n) {
            ans.add(curr);
            return;
        }
        if (open < n)
            getCombinations(n, open + 1, close, ans, curr + "(");
        if (close < open)
            getCombinations(n, open, close + 1, ans, curr + ")");
    }
}