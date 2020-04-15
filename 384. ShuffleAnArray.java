/*

Link : https://leetcode.com/problems/shuffle-an-array/

Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

*/



// Fisher-Yates Algorithm
class Solution {

    int nums[];
    int original[];
    
    Random rand = new Random();
    
    public Solution(int[] nums) {
        this.nums = nums;
        original = nums.clone();
    }
    
    public void swapAt(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int randomRange(int i, int j) {
        return rand.nextInt(j - i) + i;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        nums = original;
        original = original.clone();
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int l = nums.length;
        for (int i = 0; i < l; i++)
            swapAt(i, randomRange(i, l));
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */