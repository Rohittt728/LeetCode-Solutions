/*

Link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

*/



class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if (digits.length() == 0)
            return ans;
        
        HashMap<String, String> phoneMap = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        
        getAllCombinations("", digits, phoneMap, ans);
        return ans;
    }
    
    public void getAllCombinations(String combination, String digits, HashMap<String, String> phoneMap, List<String> ans) {
        
        if (digits.length() == 0)
            ans.add(combination);
        else {
            String d = digits.substring(0, 1);
            String letters = phoneMap.get(d);
            for (int i = 0; i < letters.length(); i++) {
                char ch = letters.charAt(i);
                getAllCombinations(combination + ch, digits.substring(1), phoneMap, ans);
            }
        }
    }
}