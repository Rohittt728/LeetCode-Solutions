/*

Link : https://leetcode.com/problems/plus-one/

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

*/
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null)
            return null;
        int l = digits.length;
        if (l == 0)
            return digits;
        int carry = 1;                      // initial carry as 1
        for (int i = l-1; i >= 0; i--) {
            int sum = digits[i] + carry;
            if (sum > 9) {
                digits[i] = 0;
                carry = 1;
            }
            else {
                carry = 0;
                digits[i] = sum;
            }
        }
        if (carry == 1) {                   // if overflow the increase array length by 1
            int ans[] = new int[l + 1];
            ans[0] = carry;
            int j = 1;
            for (int i : digits) {
                ans[j++] = i;
            }
            return ans;
        }
        return digits;
    }
}