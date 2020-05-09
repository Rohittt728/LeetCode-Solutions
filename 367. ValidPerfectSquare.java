/*

Link : https://leetcode.com/problems/valid-perfect-square/

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Output: true

Example 2:
Input: 14
Output: false

*/


// Solution 1 : nth perfect square = sum of first n odd numbers
class Solution {
    public boolean isPerfectSquare(int num) {
        
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}


// Solution 2 : Binary Search
class Solution {
    public boolean isPerfectSquare(int num) {
        
        int low = 1;
        int high = num;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (mid == num / mid && num % mid == 0)
                return true;
            else if (mid < num  / mid)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}


// Solution 3 : Newton's Method
class Solution {
    public boolean isPerfectSquare(int num) {
        
        long n = num;
        while (n * n > num)
            n = (n + num / n) >> 1;
        return n * n == num;
    }
}