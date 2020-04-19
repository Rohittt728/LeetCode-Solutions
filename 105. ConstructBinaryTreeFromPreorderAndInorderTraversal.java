/*

Link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

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

class Solution {
    
    int preIndex = 0;	// iterate over preorder
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int low = 0;
        int high = preorder.length - 1;
        return getTree(preorder, inorder, low, high);
    }
    
    public TreeNode getTree(int[] preorder, int[] inorder, int low, int high) {
        
        if (low > high)					// null node
            return null;
        
        TreeNode node = new TreeNode(preorder[preIndex++]);				// adding node
        
        if (low == high)				// leaf node
            return node;
        
        int inIndex = getInorderIndex(inorder, low, high, node.val);	// index of curr node in inorder
        																// to segregate left & right subtrees
        
        node.left = getTree(preorder, inorder, low, inIndex - 1);		// left subtree
        node.right = getTree(preorder, inorder, inIndex + 1, high);		// right subtree
        
        return node;
    }
    
    public int getInorderIndex(int inorder[], int low, int high, int target) {
        int i;
        for (i = low; i <= high; i++) {
            if (inorder[i] == target)
                return i;
        }
        return i;
    }
}