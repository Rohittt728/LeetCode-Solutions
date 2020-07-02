/*

Link : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

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
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (root == null)
            return ans;
        
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        
        while (!nodes.isEmpty()) {
            
            int nLevel = nodes.size();
            List<Integer> temp = new ArrayList<>();
            
            for (int i = 0; i < nLevel; i++) {
                
                TreeNode node = nodes.poll();
                temp.add(node.val);

                if (node.left != null)
                    nodes.add(node.left);

                if (node.right != null)
                    nodes.add(node.right);
            }
            ans.add(0, temp);
        }
        return ans;
    }
}