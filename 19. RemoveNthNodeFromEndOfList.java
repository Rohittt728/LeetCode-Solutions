/*

Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Given a linked list, remove the n-th node from the end of list and return its head.

Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.

Follow up:
Could you do this in one pass?

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Solution1 : Two Pass Solution
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = head;
        
        int len = 0;                // length of linked list
        while (root != null) {
            root = root.next;
            len++;
        }
        
        n = len - n + 1;            // n from start
        if (n == 1)                 // if its first node
            return head.next;
        
        int i = 0;
        ListNode prev = head;
        ListNode curr = head;
        while (curr != null) {
            i++;
            if (i == n) {           
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}


// Solution2 : One Pass Solution
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Adding dummy node in the start to simplify corner cases
        ListNode root = new ListNode(0);
        root.next = head;
        
        // Taking two pointers and maintaining the gap n since n is from the end
        ListNode first = root;
        ListNode second = root;
        
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        
        return root.next;
    }
}