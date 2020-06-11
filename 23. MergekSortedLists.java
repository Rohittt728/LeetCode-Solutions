/*

Link : https://leetcode.com/problems/merge-k-sorted-lists/

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null || lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        
        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }
        
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        
        while (!pq.isEmpty()) {
            head.next = pq.poll();
            head = head.next;
            
            if (head.next != null)
                pq.add(head.next);
        }
        
        return dummy.next;
    }
}