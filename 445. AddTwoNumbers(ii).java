/*

Link : https://leetcode.com/problems/add-two-numbers-ii/

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        Stack<Integer> sl1 = new Stack<Integer>();
        Stack<Integer> sl2 = new Stack<Integer>();
        
        while (l1 != null) {
            sl1.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            sl2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode dummy = null;
        int carry = 0;
        while (!sl1.isEmpty() || !sl2.isEmpty() || carry != 0) {
            int v1 = sl1.isEmpty() ? 0 : sl1.pop();
            int v2 = sl2.isEmpty() ? 0 : sl2.pop();
            
            int val = v1 + v2 + carry;
            int q = val % 10;
            carry = val / 10;
            
            ListNode node = new ListNode(q);
            
            node.next = dummy;
            dummy = node;
        }
        
        return dummy;
    }
}