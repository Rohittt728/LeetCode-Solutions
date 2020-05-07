/*

Link : https://leetcode.com/problems/cousins-in-binary-tree/

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

Note:
The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.

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


// Solution 1 : PreOrder Traversal
class Node {
    int parent;
    int depth;
}

class Solution {
    Node xNode = new Node();
    Node yNode = new Node();
    
    public boolean isCousins(TreeNode root, int x, int y) {
        findCousins(root, x, y, 0, 1);
        return xNode.parent != yNode.parent && xNode.depth == yNode.depth;
    }
    
    public void findCousins(TreeNode root, int x, int y, int parent, int depth) {
        if (root == null)
            return;
        
        if (root.val == x) {
            xNode.parent = parent;
            xNode.depth = depth;
        }
        if (root.val == y) {
            yNode.parent = parent;
            yNode.depth = depth;
        }
        
        findCousins(root.left, x, y, root.val, depth + 1);
        findCousins(root.right, x, y, root.val, depth + 1);
    }
}