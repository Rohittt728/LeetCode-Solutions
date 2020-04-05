/*

Link : https://leetcode.com/problems/median-of-two-sorted-arrays/

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

*/

/*
Solution Reference : https://www.youtube.com/watch?v=LPFhl65R7ww
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	// so that nums1 length is always smaller than nums2
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int x = nums1.length;
        int y = nums2.length;
        int l = x + y;
        
        int low = 0;
        int high = x;
        while (low <= high) {
            int partX = (low + high) / 2;
            int partY = (x + y + 1) / 2 - partX;
            
            int maxLeftX = (partX == 0) ? Integer.MIN_VALUE : nums1[partX - 1];
            int maxLeftY = (partY == 0) ? Integer.MIN_VALUE : nums2[partY - 1];
            
            int minRightX = (partX == x) ? Integer.MAX_VALUE : nums1[partX];
            int minRightY = (partY == y) ? Integer.MAX_VALUE : nums2[partY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {	// array is partitioned correctly
                if ((l & 1) == 0)
                    return (double)((Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0);
                return (double)Math.max(maxLeftX, maxLeftY);
            }
            // Binary Search Logic
            else if (maxLeftX > minRightY)
                high = partX - 1;
            else
                low = partX + 1; 
        }
        // Control reaches here only if the arrays are not sorted
        throw new IllegalArgumentException();
    }
}
