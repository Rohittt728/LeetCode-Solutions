/*

Link : https://leetcode.com/problems/count-complete-tree-nodes/

Given a complete binary tree, count the number of nodes.

Note:
Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:
Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

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


// Solution 1
class Solution {
    
    int count = 0;
    
    public int countNodes(TreeNode root) {
        inorder(root);
        return count;
    }
    
    public void inorder(TreeNode root) {
        if (root == null)
            return;
        
        inorder(root.left);
        count++;
        inorder(root.right);
    }
}



// Solution 2
class Solution {
    public int countNodes(TreeNode root) {
        
        if (root == null)
            return 0;
        
        int left = getHeightLeft(root);
        int right = getHeightRight(root);
        
        if (left == right)
            return (int)Math.pow(2, left) - 1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int getHeightLeft(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height ++;
        }
        return height;
    }
    
    public int getHeightRight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.right;
            height ++;
        }
        return height;
    }
}