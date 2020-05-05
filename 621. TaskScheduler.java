/*

Link : https://leetcode.com/problems/task-scheduler/

Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

Constraints:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].

*/



class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int len = tasks.length;
        
        int count[] = new int[26];
        for (char c : tasks)
            count[c - 'A'] ++;
        Arrays.sort(count);
        
        int max_val = count[25] - 1;
        int idle_slots = max_val * n;
        
        for (int i = 24; i >= 0 && count[i] > 0; i--)
            idle_slots -= Math.min(count[i], max_val);
        
        return idle_slots > 0 ? idle_slots + len : len;
    }
}