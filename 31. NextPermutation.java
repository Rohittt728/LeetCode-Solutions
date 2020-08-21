/*

Link : https://leetcode.com/problems/next-permutation/

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/
 

 class Solution {
    public void nextPermutation(int[] nums) {
        
        int len = nums.length;
        
        // Finding highest index i such that nums[i] < nums[i + 1]
        int i = len - 1;
        while (i > 0 && nums[i] <= nums[i - 1])
            i --;
        i --;
        
        // if no value for i possible then its already largest permutation
        if (i >= 0) {
            
            // Finding highest index j > i such that nums[j] > nums[i] 
            int j = len - 1;
            while (j >= 0 && nums[j] <= nums[i])
                j --;
            
            // swapping nums[i] & nums[j]
            swap(nums, i, j);
        }
        
        // reverse the array after i'th index (since it was now in descending order)
        reverse(nums, i + 1);
    }
    
    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int nums[], int start) {
        int i = start;
        int j = nums.length - 1;
        
        while (i < j) {
            swap(nums, i, j);
            i ++;
            j --;
        }
    }
}