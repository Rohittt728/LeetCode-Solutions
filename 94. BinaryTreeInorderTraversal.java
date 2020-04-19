/*

Link : https://leetcode.com/problems/binary-tree-inorder-traversal/

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?

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

// Solution1 : Recursion
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<Integer>();
        traverseInorder(root, ans);
        return ans;
    }
    
    public void traverseInorder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        
        traverseInorder(root.left, ans);
        ans.add(root.val);
        traverseInorder(root.right, ans);
    }
}


// Solution2 : Iterative using stack
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            
            root = st.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}


// Solution3 : Iterative without using stack (Morris Traversal)
class Solution {
	// if left is not null
	// then move current node to the rightmost node of left subtree
	// if left is null, then add to answer and move right
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode curr = root;
        TreeNode pre = null;
        
        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            }
            else {
                pre = curr.left;
                while (pre.right != null)
                    pre = pre.right;
                
                pre.right = curr;
                
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return ans;
    }
}