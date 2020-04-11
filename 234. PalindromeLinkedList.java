/*

Link : https://leetcode.com/problems/palindrome-linked-list/

Given a singly linked list, determine if it is a palindrome.

Example 1:
Input: 1->2
Output: false

Example 2:
Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// Solution1 : Iterative O(n) time and O(1) space
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        // base case
        if (head == null || head.next == null)
            return true;
        
        // find middle of linked list
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev_of_slow = null;
        ListNode midnode = null;
        while (fast != null && fast.next != null) {
            prev_of_slow = slow;
            slow= slow.next;
            fast = fast.next.next;
        }
        
        // handling odd no. of nodes case
        if (fast != null) {
            midnode = slow;
            slow = slow.next;
        }
        
        // segregating second half
        ListNode second_half = slow;
        prev_of_slow.next = null;
        
        // reverse second half
        ListNode curr = second_half;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        second_half = prev;
        
        // compare first & second half
        boolean res = compareLists(head, second_half);
        
        // reverse second half back to original
        curr = second_half;
        prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        second_half = prev;
        
        // retreiving original linked list
        if (midnode != null) {
            prev_of_slow.next = midnode;
            midnode.next = second_half;
        }
        else {
            prev_of_slow.next = second_half;
        }
        
        // result
        return res;
    }
    
    public boolean compareLists (ListNode root1, ListNode root2) {
        ListNode head1 = root1;
        ListNode head2 = root2;
        
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
}


// Solution2 : Recursive
class Solution {
    
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return isPalin(head);
    }
    
    public boolean isPalin(ListNode right) {
        
        // base case
        if (right == null)
            return true;
        
        // move to end via recursion
        boolean res = isPalin(right.next);
        if (!res)
            return false;
        
        // comparing corresponding nodes
        boolean f = (left.val == right.val);
        
        left = left.next;
        return f;
    }
}


/*

Follow up:
1. Could you do it in O(n) time and O(1) space?
-- Refer Solution1 above

*/