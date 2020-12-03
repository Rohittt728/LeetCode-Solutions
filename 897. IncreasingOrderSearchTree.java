/*

Link : https://leetcode.com/problems/increasing-order-search-tree/

Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.

Example 1:
Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

Example 2:
Input: root = [5,1,7]
Output: [1,null,5,null,7]

Constraints:
The number of nodes in the given tree will be in the range [1, 100].
0 <= Node.val <= 1000

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


// Solution 1 : Inorder Traversal
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        
        List<Integer> nodes = new ArrayList<Integer>();
        inorder(root, nodes);
        
        TreeNode dummy = new TreeNode(0);
        TreeNode curr = dummy;
        for (int n : nodes) {
            curr.right = new TreeNode(n);
            curr = curr.right;
        }
        return dummy.right;
    }
    
    public void inorder(TreeNode root, List<Integer> nodes) {
        if (root == null)
            return;
        
        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }
}


// Solution 2 : No explicit space used
class Solution {
    
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        
        TreeNode dummy = new TreeNode(0);
        curr = dummy;
        inorder(root);
        
        return dummy.right;
    }
    
    public void inorder(TreeNode root) {
        if (root == null)
            return;
        
        inorder(root.left);
        root.left = null;
        curr.right = root;
        curr = root;
        inorder(root.right);
    }
}