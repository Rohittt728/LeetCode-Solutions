/*

Link : https://leetcode.com/problems/merge-two-sorted-lists/

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        
        if (l1.val <=  l2.val)
            return mergeLists(l1, l2);
        else
            return mergeLists(l2, l1);
    }
    
    public ListNode mergeLists(ListNode l1, ListNode l2) {
        
        if (l1.next == null) {
            l1.next = l2;
            return l1;
        }
        
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode next1 = curr1.next;
        ListNode next2 = curr2.next;
        while (curr1 != null && curr2 != null) {
            
            // if curr2 is b/w curr1 and next 1; the make it curr1->curr2->next1
            if (curr1.val <= curr2.val && curr2.val <= next1.val) {
                next2 = curr2.next;
                curr1.next = curr2;
                curr2.next = next1;
                
                curr1 = curr2;
                curr2 = next2;
            }
            
            else {
                if (next1.next != null) {
                    next1 = next1.next;
                    curr1 = curr1.next;
                }
                else {
                    next1.next = curr2;
                    return l1;
                }
            }
        }
        return l1;
    }
}


// Solution2 : Recursive
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        
        if (l1.val <=  l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}