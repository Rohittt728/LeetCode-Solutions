/*

Link : https://leetcode.com/problems/repeated-dna-sequences/

All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example 1:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:
Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]

Constraints:
0 <= s.length <= 105
s[i] is 'A', 'C', 'G', or 'T'.

*/


class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        HashSet<String> prev = new HashSet<String>();
        HashSet<String> curr = new HashSet<String>();
        
        int len = s.length();
        for (int i = 0; i < len - 10 + 1; i++) {
            String str = s.substring(i, i + 10);
            if (prev.contains(str))
                curr.add(str);
            prev.add(str);
        }
        return new ArrayList<String>(curr);
    }
}