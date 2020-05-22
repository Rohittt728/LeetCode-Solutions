/*

Link : https://leetcode.com/problems/sort-characters-by-frequency/

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:
Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

*/


class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a, b) -> h.get(b) - h.get(a));
        
        for (char c : h.keySet())
            pq.add(c);
        
        String ans = "";
        
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int count = h.get(c);
            while (count > 0) {
                ans = ans + c;
                count --;
            }
        }
        return ans;
    }
}