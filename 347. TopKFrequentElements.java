/*

Link : https://leetcode.com/problems/top-k-frequent-elements/

Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/




// Solution 1
import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int len = nums.length;
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < len; i++) {
            int count = 0;
            if (h.containsKey(nums[i]))
                count = h.get(nums[i]);
            h.put(nums[i], count + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer> () {
            
            @Override
            public int compare(Integer a, Integer b) {
                return h.get(b) - h.get(a);
            }
        });
        
        for (int i : h.keySet()) {
            pq.add(i);
        }
        
        int ans[] = new int[k];
        int i = 0;
        while (i < k) {
            ans[i++] = pq.poll();
        }
        
        return ans;
    }
}



// Solution 2
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // store element and its count
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        
        for (int i : nums)
            h.put(i, h.getOrDefault(i, 0) + 1);
        
        // max heap using priority queue, on the basis on count of element
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> h.get(b) - h.get(a));
        
        for (int i : h.keySet())
            pq.add(i);
        
        int ans[] = new int[k];
        int i = 0;
        
        // poll from heap and add to answer
        while (i < k)
            ans[i++] = pq.poll();
        
        return ans;
    }
}
