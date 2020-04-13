/*

Link : https://leetcode.com/problems/merge-sorted-array/

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

Example:
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

*/


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int j = 0, len = m;		// nums1 variables
        int i = 0;				// nums2 variables
        
        while (i < n) {
            j = len - 1;
            
            while (j >= 0 && nums2[i] < nums1[j]) {		// moving forward elements in nums1 
                nums1[j + 1] = nums1[j];				// to insert nums2 elements at right position
                j --;
            }
            
            nums1[j + 1] = nums2[i];					// adding nums2 element
            len ++;										// increase nums1 length by 1
            i ++;										// iterating through nums2
        }
    }
}