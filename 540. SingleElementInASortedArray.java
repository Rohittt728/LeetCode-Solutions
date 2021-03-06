/*

Link : https://leetcode.com/problems/single-element-in-a-sorted-array/

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10

Note: Your solution should run in O(log n) time and O(1) space.

*/


// Solution 1 : Xor O(n)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int p = 0;
        for (int i : nums)
            p ^= i;
        
        return p;
    }
}



// Solution 2 : Binary Search O(log n)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return nums[mid];
            
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1])
                    low = mid + 2;
                else
                    high = mid - 2;
            }
            else {
                if (nums[mid] == nums[mid - 1])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return nums[low];
    }
}



// Solution 3 : Short Binary Search
class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (mid % 2 == 1)
                mid --;
            
            if (nums[mid] == nums[mid + 1])
                low = mid + 2;
            
            else
                high = mid;
        }
        return nums[low];
    }
}