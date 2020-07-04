/*

Link : https://leetcode.com/problems/ugly-number-ii/

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:
Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note:  
1 is typically treated as an ugly number.
n does not exceed 1690.

*/



class Solution {
    public int nthUglyNumber(int n) {
        
        int nums[] = new int[n];
        nums[0] = 1;
        
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(n2, Math.min(n3, n5));
            nums[i] = min;
            
            if (nums[i] == n2)
                n2 = 2 * nums[++p2];
            if (nums[i] == n3)
                n3 = 3 * nums[++p3];
            if (nums[i] == n5)
                n5 = 5 * nums[++p5];
        }
        return nums[n - 1];
    }
}