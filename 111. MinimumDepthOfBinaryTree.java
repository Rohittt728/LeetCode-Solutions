/*

Link : https://leetcode.com/problems/minimum-depth-of-binary-tree/

Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:
Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5

Constraints:
The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000

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

// Solution 1 : Recursion DFS
class Solution {
    public int minDepth(TreeNode root) {
        
        if (root == null)
            return 0;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        return (left == 0 || right == 0) ? (left + right + 1) : (1 + Math.min(left, right));
    }
}



// Solution 2 : BFS
class Solution {
    public int minDepth(TreeNode root) {
        
        if (root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int depth = 1;
        
        while (q.size() > 0) {
            int size = q.size();
            
            while (size-- > 0) {
                TreeNode node = q.poll();
                
                if (node.left == null && node.right == null)
                    return depth;
                
                if (node.left != null)
                    q.add(node.left);
                
                if (node.right != null)
                    q.add(node.right);
            }
            depth++;
        }
        return 0;
    }
}