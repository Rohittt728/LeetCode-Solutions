/*

Link : https://leetcode.com/problems/reverse-pairs/

Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:
Input: [1,3,2,3,1]
Output: 2

Example2:
Input: [2,4,3,5,1]
Output: 3

Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer.

*/


class Solution {
    public int reversePairs(int[] nums) {
        
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    public int merge (int nums[], int low, int mid, int high) {
        
        int count = 0;
        for (int i = low, j = mid + 1; i <= mid; i++) {
            while (j <= high && nums[i] > (2 * (long)nums[j]))
                j++;
            
            count += (j - (mid + 1));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j])
                list.add(nums[i++]);
            else
                list.add(nums[j++]);
        }
        
        while (i <= mid)
            list.add(nums[i++]);
        while (j <= high)
            list.add(nums[j++]);
        
        j = 0;
        for (i = low; i <= high; i++)
            nums[i] = list.get(j++);
        
        return count;
    }
    
    public int mergeSort(int nums[], int i, int j) {
        
        int ans = 0;
        if (i < j) {
            int mid = (i + j) / 2;
            
            ans += mergeSort(nums, i, mid);
            ans += mergeSort(nums, mid + 1, j);
            ans += merge(nums, i, mid, j);
        }
        return ans;
    }
}