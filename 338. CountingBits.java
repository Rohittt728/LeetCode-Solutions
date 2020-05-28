/*

Link : https://leetcode.com/problems/counting-bits/

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:
Input: 2
Output: [0,1,1]

Example 2:
Input: 5
Output: [0,1,1,2,1,2]

Follow up:
1. It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
2. Space complexity should be O(n).
3. Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

*/


// Solution 1 : Brute force
class Solution {
    public int[] countBits(int num) {
        
        int ans[] = new int[num + 1];
        
        for (int i = 0; i <= num; i++) {
            ans[i] = countSetBits(i);
        }
        
        return ans;
    }
    
    public int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count ++;
        }
        return count;
    }
}


// Solution 2 : DP
class Solution {
    public int[] countBits(int num) {
        
        int ans[] = new int[num + 1];
        
        for (int i = 1; i <= num; i++)
            ans[i] = 1 + ans[i & (i - 1)];
        
        return ans;
    }
}