/*

Link : https://leetcode.com/problems/copy-list-with-random-pointer/

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.

Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]

Example 4:
Input: head = []
Output: []
Explanation: Given linked list is empty (null pointer), so return null.

Constraints:
-10000 <= Node.val <= 10000
Node.random is null or pointing to a node in the linked list.
Number of Nodes will not exceed 1000.

*/



/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// Solution 1 : Hashmap
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        
        Map<Node, Node> h = new HashMap<>();
        
        // copying all nodes
        Node node = head;
        while (node != null) {
            h.put(node, new Node(node.val));
            node = node.next;
        }
        
        // assigning pointers
        node = head;
        while (node != null) {
            h.get(node).next = h.get(node.next);
            h.get(node).random = h.get(node.random);
            node = node.next;
        }
        
        return h.get(head);
    }
}


// Solution 1 : O(1) space
class Solution {
    public Node copyRandomList(Node head) {
        
        if (head == null)
            return null;
        
        // copying each node and insert after each node respectively
        Node p = head;
        while (p != null) {
            Node copy = new Node(p.val);
            copy.next = p.next;
            p.next = copy;
            
            p = copy.next;
        }
        
        // copy pointers for each node
        p = head;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            
            p = p.next.next;
        }
        
        // Restore the original list, extract the copy list
        p = head;
        Node newHead = head.next;
        while (p != null) {
            Node temp = p.next;
            p.next = temp.next;
            
            if (temp.next != null)
                temp.next = temp.next.next;
            p = p.next;
        }
        
        return newHead;
    }
}