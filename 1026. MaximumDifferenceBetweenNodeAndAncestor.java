/*

Link : https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

Given the root of a binary tree, find the maximum value V for which there exist different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.

Example 1:
Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

Example 2:
Input: root = [1,null,2,null,0,3]
Output: 3

Constraints:
The number of nodes in the tree is in the range [2, 5000].
0 <= Node.val <= 105

*/



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Solution 1 : Brute Force
class Solution {
    
    int ans;
    public int maxAncestorDiff(TreeNode root) {
        
        ans = 0;
        traverse(root, root.val, root.val);
        return ans;
    }
    
    public void traverse(TreeNode root, int curMax, int curMin) {
        
        if (root == null)
            return;
        
        int temp = Math.max(Math.abs(curMax - root.val), Math.abs(curMin - root.val));
        ans = Math.max(ans, temp);
        
        curMax = Math.max(curMax, root.val);
        curMin = Math.min(curMin, root.val);
        
        traverse(root.left, curMax, curMin);
        traverse(root.right, curMax, curMin);
    }
}


// Solution 2 : Efficient approach
class Solution {
    
    public int maxAncestorDiff(TreeNode root) {
        
        return traverse(root, root.val, root.val);
    }
    
    public int traverse(TreeNode root, int curMax, int curMin) {
        
        if (root == null)
            return curMax - curMin;
        
        curMax = Math.max(curMax, root.val);
        curMin = Math.min(curMin, root.val);
        
        int left = traverse(root.left, curMax, curMin);
        int right = traverse(root.right, curMax, curMin);
        
        return Math.max(left, right);
    }
}