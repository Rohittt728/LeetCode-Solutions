/*

Link : https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

Example 1:
Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Note:
1 <= preorder.length <= 100
The values of preorder are distinct.

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

// Solution 1
class Solution {
    
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        if (len == 0)
            return null;
        
        return bstPreorder(preorder, 0, len - 1);
    }
    
    public TreeNode bstPreorder(int preorder[], int low, int high) {
        
        if (low > high)
            return null;
        
        TreeNode root = new TreeNode(preorder[low]);
        
        int j;
        for (j = low; j <= high; j++) {
            if (preorder[j] > preorder[low]) {
                break;
            }
        }
        root.left = bstPreorder(preorder, low + 1, j - 1);
        root.right = bstPreorder(preorder, j, high);   

        return root;
    }
}


// Solution2 : Cool approach
class Solution {
    
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        if (len == 0)
            return null;
        
        return bstPreorder(preorder, Integer.MAX_VALUE);
    }
    
    public TreeNode bstPreorder(int preorder[], int parent) {
        
        if (index == preorder.length || preorder[index] > parent)
            return null;
        
        int curr = preorder[index++];
        TreeNode root = new TreeNode(curr);
        
        root.left = bstPreorder(preorder, curr);
        root.right = bstPreorder(preorder, parent);   

        return root;
    }
}

