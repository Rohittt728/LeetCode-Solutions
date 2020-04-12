/*

Link : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:
Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Solution1 : Recursive
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getBST(nums, 0, nums.length - 1);
    }
    
    public TreeNode getBST(int nums[], int low, int high) {
        
        if (low > high)
            return null;
        
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = getBST(nums, low, mid - 1);
        root.right = getBST(nums, mid + 1, high);
        
        return root;
    }
}


// Solution2 : Iterative, using stack to keep track
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        int len = nums.length;
        if (len == 0)
            return null;
        
        int low = 0;
        int high = len - 1;
        
        TreeNode root = new TreeNode(0);
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        Stack<Integer> lower = new Stack<Integer>();
        Stack<Integer> upper = new Stack<Integer>();
        nodes.push(root);
        lower.push(low);
        upper.push(high);
        
        while (!nodes.isEmpty()) {
            TreeNode head = nodes.pop();
            low = lower.pop();
            high = upper.pop();
            int mid = low + (high-low) / 2;
            head.val = nums[mid];
            
            if (low < mid) {
                head.left = new TreeNode(0);
                nodes.push(head.left);
                lower.push(low);
                upper.push(mid - 1);
            }
            
            if (high > mid) {
                head.right = new TreeNode(0);
                nodes.push(head.right);
                lower.push(mid + 1);
                upper.push(high);
            }
        }
        return root;
    }
}
