/*

Link : https://leetcode.com/problems/longest-consecutive-sequence/

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

*/


class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> h = new HashSet<Integer>();
        for (int i : nums)
            h.add(i);
        
        int cur_streak = 1;
        int max_streak = 0;
        
        for (int i : h) {
            if (!h.contains(i - 1)) {
                while (h.contains(i + 1)) {
                    i += 1;
                    cur_streak += 1;
                }
                max_streak = Math.max(max_streak, cur_streak);
                cur_streak = 1;
            }
        }
        return max_streak;
    }
}