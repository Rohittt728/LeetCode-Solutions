/*

Link : https://leetcode.com/problems/group-anagrams/

Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:
All inputs will be in lowercase.
The order of your output does not matter.

*/

class Solution {
	// Sorting Solution
	// Time Complexity O(NKlog(K))
	// Space Complexity O(NK)
	// N is total strings, K is length of longest string
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, ArrayList<String>> h = new HashMap<String, ArrayList<String>>();
        for (String s : strs) {
            char temp[] = s.toCharArray(); 
            Arrays.sort(temp); 
            String k = new String(temp);
            if (!h.containsKey(k)) {
                h.put(k, new ArrayList<String>());
            }
            h.get(k).add(s);
        }
        return new ArrayList(h.values());
    }
}