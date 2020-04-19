/*

Link : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Follow up:
1. You may only use constant extra space.
2. Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

Example 1:
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

Constraints:
The number of nodes in the given tree is less than 4096.
-1000 <= node.val <= 1000

*/



/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// Solution1 : Using level order traversal logic, single queue
class Solution {
    public Node connect(Node root) {
        
        if (root == null)
            return root;
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        Node curr = null;
        while (!q.isEmpty()) {
            
            int size = q.size();
            for (int i = 0; i < size; i++) {
                
                Node prev = curr;
                curr = q.poll();
                
                if (i > 0)
                    prev.next = curr;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            curr.next = null;
        }
        return root;
    }
}


// Solution 2 : Recursion with assumption
class Solution {
	// we deduce that node.left.next = node's right child
	// and node.right.next = node's next left child; in case it is last in level then = null
	// Assumption : it is complete BT
    public Node connect(Node root) {
        if (root == null)
            return root;
        
        root.next = null;
        connectRecur(root);
        return root;
    }
    
    public void connectRecur(Node root) {
        if (root == null)
            return;
        
        if (root.left != null)
            root.left.next = root.right;
        if (root.right != null)
            root.right.next = (root.next != null) ? root.next.left : null;
        
        connectRecur(root.left);
        connectRecur(root.right);
    }
}