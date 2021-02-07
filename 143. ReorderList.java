/*

Link : https://leetcode.com/problems/reorder-list/

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:
Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        if (head == null || head.next == null)
            return;
        
        // Find the middle of list
        ListNode mid = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of list
        ListNode prev = mid;
        ListNode curr = mid.next;
        ListNode next = curr.next;
        while (next != null) {
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
        }
        
        // Reordering alternate first half and second half
        ListNode first = head;
        ListNode second = mid.next;
        while (first != mid) {
            mid.next = second.next;
            second.next = first.next;
            first.next = second;
            first = second.next;
            second = mid.next;
        }
    }
}