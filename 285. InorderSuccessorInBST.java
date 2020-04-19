/*

Link : https://leetcode.com/problems/inorder-successor-in-bst/

Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

If the given node has no in-order successor in the tree, return null.

Example 1:
Input: {1,#,2}, node with value 1
Output: 2
Explanation:
  1
   \
    2

Example 2:
Input: {2,1,3}, node with value 1
Output: 2
Explanation: 
    2
   / \
  1   3

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


// Solution1 : Iterative
public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null)
            return null;
        
        TreeNode ans = null;
        while (root != null && root.val != p.val) {
            
            if (p.val < root.val) {
                ans = root;
                root = root.left;
            }
            else if (p.val > root.val)
                root = root.right;
        }
        
        if (root == null)
            return null;
        if (root.right == null)
            return ans;
        
        root = root.right;
        while(root.left != null)
            root = root.left;
        return root;
    }
}


// Solution2 : Recursive
public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    
    TreeNode ans;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        ans = null;
        findNode(root, p);
        return ans;
    }
    
    public void findNode(TreeNode root, TreeNode p) {
        if (root == null)
            return;
        
        if (p.val < root.val) {
            ans = root;
            findNode(root.left, p);
            return;
        }
        if (p.val >= root.val) {
            findNode(root.right, p);
            return;
        }
    }
}