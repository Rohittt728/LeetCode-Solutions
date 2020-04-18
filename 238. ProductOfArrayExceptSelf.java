/*

Link : https://leetcode.com/problems/product-of-array-except-self/

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]

Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
1. Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*/


// Solution1 : Using extra space
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int len = nums.length;
        
        int left[] = new int[len];
        left[0] = 1;
        
        int right[] = new int[len];
        right[len - 1] = 1;
        
        int ans[] = new int[len];
        
        for (int i = 1; i < len; i++)
            left[i] = left[i - 1] * nums[i - 1];
        
        for (int i = len - 2; i >= 0; i--)
            right[i] = right[i + 1] * nums[i + 1];
        
        for (int i = 0; i < len; i++)
            ans[i] = left[i] * right[i];
        
        return ans;
    }
}



// Solution2 : Without using extra space
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int len = nums.length;
        
        int ans[] = new int[len];
        ans[0] = 1;
        
        for (int i = 1; i < len; i++)
            ans[i] = ans[i - 1] * nums[i - 1];
        
        int f = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] = ans[i] * f;
            f = f * nums[i];
        }
        
        return ans;
    }
}