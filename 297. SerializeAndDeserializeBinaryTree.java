/*

Link : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 
You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

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


// Solution 1 : Level Order Traversal
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> ans = new ArrayList<String>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null)
                ans.add("null");
            else {
                ans.add("" + node.val);
                q.add(node.left);
                q.add(node.right);
            }
        }
        return String.join(",", ans);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String tree[] = data.split(",");
        if (tree[0].equals("null"))
            return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                
                TreeNode left = null;
                if (!tree[i].equals("null"))
                    left = new TreeNode(Integer.parseInt(tree[i]));
                node.left = left;
                q.add(left);
                i ++;
                
                TreeNode right = null;
                if (!tree[i].equals("null"))
                    right = new TreeNode(Integer.parseInt(tree[i]));
                node.right = right;
                q.add(right);
                i ++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));




// Solution 2 : PreOrder Traversal
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (root == null)
            return null;
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        ArrayList<String> ans = new ArrayList<String>();
        
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node != null) {
                ans.add("" + node.val);
                st.push(node.right);
                st.push(node.left);
            }
            else
                ans.add("null");
        }
        return String.join(",", ans);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        
        int i[] = {0};
        String tree[] = data.split(",");
        return getTree(tree, i);
    }
    
    public TreeNode getTree(String tree[], int i[]) {
        if (tree[i[0]].equals("null"))
            return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(tree[i[0]]));
        
        i[0] = i[0] + 1;
        root.left = getTree(tree, i);
        
        i[0] = i[0] + 1;
        root.right = getTree(tree, i);
        
        return root;
    }
}