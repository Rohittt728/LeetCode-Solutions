/*

Link : https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
Return the sum of these numbers.

Example 1:
Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

Note:
The number of nodes in the tree is between 1 and 1000.
node.val is 0 or 1.
The answer will not exceed 2^31 - 1.

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
    public int sumRootToLeaf(TreeNode root) {
        
        return sumRootToLeafBinary(root, "");
    }
    
    public int sumRootToLeafBinary(TreeNode root, String s) {
        
        if (root == null)
            return 0;
        
        s = s + root.val;
        
        if (root.left == null && root.right == null)
            return binaryStringToNum(s);
        
        return sumRootToLeafBinary(root.left, s) + sumRootToLeafBinary(root.right, s);
    }
    
    public int binaryStringToNum(String s) {
        int len = s.length();
        int num = 0, count = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '1')
                num += Math.pow(2, count);
            count ++;
        }
        return num;
    }
}