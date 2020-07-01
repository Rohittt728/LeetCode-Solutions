/*

Link : https://leetcode.com/problems/arranging-coins/

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:
n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤
Because the 3rd row is incomplete, we return 2.

Example 2:
n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤
Because the 4th row is incomplete, we return 3.

*/



// Solution 1
class Solution {
    public int arrangeCoins(int n) {
        
        int k = 1;
        int count = 0;
        
        while (true) {
            n -= k;
            if (n < 0)
                break;
            count ++;
            k ++;
        }
        
        return count;
    }
}



// Solution 2 : Maths
/*
* 
    k*(k + 1)/2 <= N
    k*(k+1) <= 2N
    (k + 1/2)^2 - 1/4 <= 2N
    
    k <= sqrt(2N + 1/4) - 1/2
*
*/
class Solution {
    public int arrangeCoins(int n) {
        
        return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }
}



// Solution 3 : Binary Search
class Solution {
    public int arrangeCoins(int n) {
        
        long low = 0;
        long high = n;
        
        long val, mid;
        
        while (low <= high) {
            
            mid = low + (high - low) / 2;
            val = mid * (mid + 1) / 2;
            
            if (val == n)
                return (int)mid;
            
            if (val < n)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return (int)high;
    }
}

