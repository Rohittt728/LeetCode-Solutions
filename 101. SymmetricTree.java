/*

Link : https://leetcode.com/problems/symmetric-tree/

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 
Follow up: Solve it both recursively and iteratively.

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        
        return checkSymmetric(root.left, root.right);
    }
    
    public boolean checkSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        
        return (root1.val == root2.val) && (checkSymmetric(root1.left, root2.right)) && (checkSymmetric(root1.right, root2.left));
    }
}



// Solution2 : Iterative, using queue
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root.left);
        q.add(root.right);
        
        while (!q.isEmpty()) {
            TreeNode h1 = q.poll();
            TreeNode h2 = q.poll();
            
            if (h1 == null && h2 == null)
                continue;
            if (h1 == null || h2 == null)
                return false;
            if (h1.val != h2.val)
                return false;
            q.add(h1.left);
            q.add(h2.right);
            q.add(h1.right);
            q.add(h2.left);
        }
        return true;
    }
}