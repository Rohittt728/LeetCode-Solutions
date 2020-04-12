/*

Link : https://leetcode.com/problems/binary-tree-level-order-traversal/

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        getLevelOrder(root, 0, ans);
        return ans;
    }
    
    public void getLevelOrder(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null)
            return;
        
        if(ans.size() == level)
            ans.add(new ArrayList<Integer>());
        
        ans.get(level).add(root.val);
        
        getLevelOrder(root.left, level + 1, ans);
        getLevelOrder(root.right, level + 1, ans);
    }
}



// Solution1 : Iterative
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (root == null)
            return ans;
        
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        Queue<Integer> level = new LinkedList<Integer>();
        
        nodes.add(root);
        level.add(0);
        
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int l = level.poll();
            
            if (ans.size() == l)
                ans.add(new ArrayList<Integer>());
            ans.get(l).add(node.val);
            
            if (node.left != null) {
                nodes.add(node.left);
                level.add(l + 1);
            }
            
            if (node.right != null) {
                nodes.add(node.right);
                level.add(l + 1);
            }
        }
        return ans;
    }
}