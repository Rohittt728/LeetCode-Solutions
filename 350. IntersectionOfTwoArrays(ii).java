/*

Link : https://leetcode.com/problems/intersection-of-two-arrays-ii/

Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

*/


class Solution {
    public int[] intersect(int[] nums, int[] nums2) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        int l1 = nums.length;
        int l2 = nums2.length;

        // taking count of each element in hashmap for 1st array
        for (int i = 0; i < l1; i++) {
            if (h.containsKey(nums[i])) {
                int count = h.get(nums[i]);
                h.put(nums[i], count+1);
            }
            else {
                h.put(nums[i], 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();

        // decreasing count of each element till it reaches 0 and adding as answer array
        for (int i = 0; i < l2; i++) {
            if (h.containsKey(nums2[i])) {
                int count = h.get(nums2[i]);
                if (count > 0) {
                    h.put(nums2[i], count-1);
                    ans.add(nums2[i]);
                }
            }
        }
        int arr[] = new int[ans.size()];
        int j = 0;
        for (int i : ans)
            arr[j++] = i;
        return arr;
    }
}

/*

Follow ups:
1. What if the given array is already sorted? How would you optimize your algorithm?
-- Iterate over the two arrays simultaneously (two pointer approach), no extra memory. Time Complexity O(n + m)

2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
-- If arrays are sorted we could use use binary search; for each element in the shorter array, search in the larger one. Time Complexity O(nlog(m)); n is length of shorter array, m is length of larger one

3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
-- We will then take some part of array, do the computation with above logic (in case already sorted, use the sorting logic in 1st follow up), then load the remaining part accordingly.

*/