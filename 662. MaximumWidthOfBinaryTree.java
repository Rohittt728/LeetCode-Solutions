/*

Link : https://leetcode.com/problems/maximum-width-of-binary-tree/

Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

Example 2:
Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).

Example 3:
Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).

Example 4:
Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.

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
    public int widthOfBinaryTree(TreeNode root) {
        
        if (root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Integer> h = new HashMap<>();
        q.add(root);
        h.put(root, 1);
        
        int maxWidth = 0;
        
        while (!q.isEmpty()) {
            
            int len = q.size();
            int start = 0, end = 0;
            for (int i = 0; i < len; i++) {
                
                TreeNode node = q.poll();
                if (i == 0)
                    start = h.get(node);
                if (i == len - 1)
                    end = h.get(node);
                
                if (node.left != null) {
                    q.add(node.left);
                    h.put(node.left, 2 * h.get(node));
                }
                if (node.right != null) {
                    q.add(node.right);
                    h.put(node.right, 2 * h.get(node) + 1);
                }
            }
            int width = end - start + 1;
            maxWidth = Math.max(width, maxWidth);
        }
        return maxWidth;
    }
}