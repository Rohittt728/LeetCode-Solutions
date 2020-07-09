/*

Link : https://leetcode.com/problems/longest-duplicate-substring/

Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)

Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)

Example 1:
Input: "banana"
Output: "ana"

Example 2:
Input: "abcd"
Output: ""

Note:
2 <= S.length <= 10^5
S consists of lowercase English letters.

*/


// Solution : Binary Search + Rolling Hash
class Solution {
    
    int slen, a = 26, mod = 1 << 30;
    
    public String longestDupSubstring(String s) {
        
        slen = s.length();
        int low = 1;
        int high = slen - 1;
        int startIndex = 0;
            
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            startIndex = searchString(s, mid);
            
            if (startIndex == -1)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        startIndex = searchString(s, high);
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + high);
    }
    
    public int searchString(String s, int len) {
        
        // hash for first string
        long hash = 0;
        for (int i = 0; i < len; i++)
            hash = (hash * a % mod + s.charAt(i)) % mod;
        
        // precomputing power like p^(len - 1)
        long p = 1;
        for (int i = 1; i < len; i++)
            p = (p * a) % mod;
        
        HashMap<Long, List<Integer>> visited = new HashMap<>();
        visited.put(hash, new ArrayList<Integer>());
        visited.get(hash).add(0);
        
        for (int i = 1; i < slen - len + 1; i++) {
            
            // removing old value at index (i-1)
            hash = (hash - (p * s.charAt(i - 1)) % mod) % mod;
            // adding new value at index (i+len-1)
            hash = ((hash * a) % mod + s.charAt(i + len - 1)) % mod;
            
            if (visited.containsKey(hash)) {
                for (int start : visited.get(hash)) {
                    if (s.substring(start, start + len).equals(s.substring(i, i + len)))
                        return i;
                }
            }
            else
                visited.put(hash, new ArrayList<Integer>());
            
            visited.get(hash).add(i);
        }
        return -1;
    }
}