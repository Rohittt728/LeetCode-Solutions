/*

Link : https://leetcode.com/problems/validate-binary-search-tree/

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

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


// Solution1 : Recursive, maintaining min and max limit for each node
class Solution {
    public boolean isValidBST(TreeNode root) {
        double min = Integer.MIN_VALUE - 1.0;
        double max = Integer.MAX_VALUE + 1.0;
        return isBST(root, min, max);
    }
    
    public boolean isBST(TreeNode root, double min, double max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
}


// Solution2 : Recursive, without defining max min
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
    
    public boolean isBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null)
            return true;
        
        int val = root.val;
        
        if (lower != null && val <= lower)
            return false;
        if (upper != null && val >= upper)
            return false;
        
        return isBST(root.left, lower, val) && isBST(root.right, val, upper);
    }
}


// Solution3 : Iterative approach to Solution2
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        Stack<Integer> lower = new Stack<Integer>();
        Stack<Integer> upper = new Stack<Integer>();
        
        nodes.push(root);
        lower.push(null);
        upper.push(null);
        
        Integer low = null, high = null;
        int val = 0;
        while (!nodes.isEmpty()) {
            root = nodes.pop();
            low = lower.pop();
            high = upper.pop();
            
            if (root == null)
                continue;
            val = root.val;
            if (low != null && val <= low)
                return false;
            if (high != null && val >= high)
                return false;
            
            if (root.left != null) {
                nodes.push(root.left);
                lower.push(low);
                upper.push(val);
            }
            
            if (root.right != null) {
                nodes.push(root.right);
                lower.push(val);
                upper.push(high);
            }
        }
        return true;
    }
}


// Solution4 : Iterative, inorder traversal
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        double min = Integer.MIN_VALUE - 1.0;
        while (!st.isEmpty() || root != null) {
            
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            
            root = st.pop();
            if (root.val <= min)
                return false;
            min = root.val;
            root = root.right;
        }
        return true;
    }
}

