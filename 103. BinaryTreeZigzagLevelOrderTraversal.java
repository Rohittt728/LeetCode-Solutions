/*

Link : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:

Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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


class Solution {

	// using single queue and a direction pointer
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (root == null)
            return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean leftToRight = true;		// decide direction
        
        while (!q.isEmpty()) {
            
            List<Integer> temp = new ArrayList<Integer>();
            int size = q.size();				// current size to fix iteration to specific level
            for (int i = 0; i < size; i++) {	
                
                TreeNode node = q.poll();
                if (leftToRight)
                    temp.add(node.val);
                else
                    temp.add(0, node.val);		// if RightToLeft, then adding to 0th index
                
                if (node.left != null)			// adding children(next level) to queue
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            
            ans.add(temp);
            leftToRight = !leftToRight;			// reversing direction
        }
        return ans;
    }
}