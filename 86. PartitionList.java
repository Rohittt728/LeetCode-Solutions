/*

Link : https://leetcode.com/problems/partition-list/

Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]

Constraints:
The number of nodes in the tree is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200

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
    public ListNode partition(ListNode head, int x) {
        
        if (head == null || head.next == null)
            return head;
        
        ListNode first = new ListNode();
        ListNode root1 = first;
        ListNode second = new ListNode();
        ListNode root2 = second;
        
        while (head != null) {
            if (head.val < x) {
                first.next = head;
                first = first.next;
            }
            else {
                second.next = head;
                second = second.next;
            }
            head = head.next;
        }
        
        second.next = null;
        first.next = root2.next;
        return root1.next;
    }
}