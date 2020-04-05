/*

Link : https://leetcode.com/problems/add-two-numbers/

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root1 = l1;
        ListNode root2 = l2;
        ListNode node = new ListNode(0);    // dummy head node to return list
        ListNode root = node;
        int sum = 0, rem = 0;
        while (root1 != null || root2 != null) {        // either of the lists is not null
            int v1 = (root1 != null) ? root1.val : 0;   
            int v2 = (root2 != null) ? root2.val : 0;
            sum = sum + v1 + v2;
            rem = sum % 10;                             
            sum = sum / 10;                             // carry forward
            root.next = new ListNode(rem);              // storing sum as a new list
            root = root.next;
            if (root1 != null)                          // linked list traversal
                root1 = root1.next;
            if (root2 != null)
                root2 = root2.next;
        }
        
        if (sum != 0)                       // check for overflow in addition
             root.next = new ListNode(sum);
        return node.next;
    }
}