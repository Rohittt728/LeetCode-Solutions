/*

Link : https://leetcode.com/problems/fraction-to-recurring-decimal/

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:
Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:
Input: numerator = 2, denominator = 1
Output: "2"

Example 3:
Input: numerator = 2, denominator = 3
Output: "0.(6)"

*/


class Solution {
    public String fractionToDecimal(int nume, int deno) {
        
        if (deno == 0)
            return "";
        if (nume == 0)
            return "0";
        
        String ans = "";
        if ((deno < 0) ^ (nume < 0))
            ans += "-";
        
        long num = nume;
        long den = deno;
        num = Math.abs(num);
        den = Math.abs(den);
        
        long quo = num / den;
        ans += String.valueOf(quo);
        
        long rem = (num % den) * 10;
        if (rem == 0)
            return ans;
        
        ans += ".";
        HashMap<Long, Integer> h = new HashMap<Long, Integer>();
        while (rem != 0) {
            if (h.containsKey(rem)) {
                int start = h.get(rem);
                String part1 = ans.substring(0, start);
                String part2 = ans.substring(start, ans.length());
                ans = part1 + "(" + part2 + ")";
                return ans;
            }
            h.put(rem, ans.length());
            quo = rem / den;
            ans += String.valueOf(quo);
            rem = (rem % den) * 10;
        }
        return ans;
    }
}