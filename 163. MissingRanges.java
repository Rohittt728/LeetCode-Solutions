/*

Link : https://leetcode.com/problems/missing-ranges/

Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:
Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

*/



// Solution1 : clean approach
public class Solution {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        
        List<String> ans = new ArrayList<String>();
        int len = nums.length;
        if (len == 0)
            ans.add(getRange(lower, upper));
        
        for (int i = 0; i < len; i++) {
            if (i == 0 && nums[i] > lower) {
                ans.add(getRange(lower, nums[i] - 1));
            }
            
            if (i > 0 && nums[i] != nums[i - 1] && nums[i] != nums[i - 1] + 1) {
                if (nums[i - 1] == upper)
                    return ans;
                ans.add(getRange(nums[i-1] + 1, nums[i] - 1));
            }
            
            if (i == len - 1 && nums[i] < upper) {
                ans.add(getRange(nums[i] + 1, upper));
            }
        }
        return ans;
    }
    
    public String getRange (int i, int j) {
        return (i == j) ? String.valueOf(i) : String.format("%d->%d", i, j);
    }
}




// Solution2
public class Solution {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        
        List<String> ans = new ArrayList<String>();
        int len = nums.length;
        // if (len == 0)
        //     ans.add(getRange(lower, upper));
        
        int start = lower;
        for (int i = 0; i < len; i++) {
            if (i < len - 1 && nums[i] == nums[i + 1])
                continue;
                
            if (nums[i] == start)
                start ++;
            else {
                ans.add(getRange(start, nums[i] - 1));
                if (nums[i] == upper)
                    return ans;
                start = nums[i] + 1;
            }
        }
        if (start <= upper)
            ans.add(getRange(start, upper));
        
        return ans;
    }
    
    public String getRange (int i, int j) {
        return (i == j) ? String.valueOf(i) : String.format("%d->%d", i, j);
    }
}
