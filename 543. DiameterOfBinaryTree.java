/*

Link : https://leetcode.com/problems/diameter-of-binary-tree/

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

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


// Solution1 : Recursive, more complex, finding height separately
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        
        int ans = getDiameter(root);
        return ans - 1;
    }
    
    public int getDiameter(TreeNode root) {
        if (root == null)
            return 0;
        
        int lheight = height(root.left);
        int rheight = height(root.right);
        
        int ldiameter = getDiameter(root.left);
        int rdiameter = getDiameter(root.right);
        
        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
    }
    
    public int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}


// Solution1 : Recursive, less complex, finding height in the same method
class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        getDiameter(root);
        return ans - 1;
    }
    
    public int getDiameter(TreeNode root) {
        if (root == null)
            return 0;
        
        int lHeight = getDiameter(root.left);
        int rHeight = getDiameter(root.right);
        
        ans = Math.max(ans, lHeight + rHeight + 1);
        
        return 1 + Math.max(lHeight, rHeight);
    }
}