/*

Link : https://leetcode.com/problems/rotate-array/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/


// Solution1 : using extra memory
class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        if (k == 0)
            return;
        int ans[] = new int[l];
        k = l - k;
        for (int i = 0; i < l; i++) {
            ans[i] = nums[k++];
            if (k == l)
                k = 0;
        }
        for (int i = 0; i < l; i++) {
            nums[i] = ans[i];
        }
    }
}



// Solution2 : using reversal logic
class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        reverse (nums, 0, l-1);
        reverse (nums, 0, k - 1);
        reverse (nums, k, l - 1);
    }
    
    public void reverse (int nums[], int l, int h) {
        while (l < h) {
            int temp = nums[l];
            nums[l] = nums[h];
            nums[h] = temp;
            l ++;
            h --;
        }
    }
}


// Solution2 : one pass using cyclic replacements
class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        int count = 0;
        for (int i = 0; count < l; i++) {
            int currIndex = i;
            int prev = nums[i];
            while (true) {
                int nextIndex = (currIndex + k) % l;
                int temp = nums[nextIndex];
                nums[nextIndex] = prev;
                prev = temp;
                currIndex = nextIndex;
                count ++;
                if (i == currIndex)
                    break;
            }
        }
    }
}







