/*

Link : https://leetcode.com/problems/random-pick-with-weight/

Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:
1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.

Example 1:
Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]

Example 2:
Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]

Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.

*/



class Solution {

    int sum[];
    Random rand;
    int n;
    
    public Solution(int[] w) {
        rand = new Random();
        
        n = w.length;
        sum = new int[n];
        
        sum[0] = w[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + w[i];
    }
    
    public int pickIndex() {
        int idx = rand.nextInt(sum[n - 1]) + 1;
        int ans = Arrays.binarySearch(sum, idx);
        if (ans < 0)
            ans = -(ans + 1);
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */