/*

Link : https://leetcode.com/problems/reverse-linked-list/

Reverse a singly linked list.

Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?

*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// Solution1 : Iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;
        
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}



// Solution2 : Recursive
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if (head == null || head.next == null)
            return head;
        
        ListNode n = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return n;
    }
}