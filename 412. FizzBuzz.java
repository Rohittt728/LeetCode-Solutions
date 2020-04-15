/*

Link : https://leetcode.com/problems/fizz-buzz/

Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:
n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

*/


class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<String>();
        boolean isDivisibleBy3 = false;
        boolean isDivisibleBy5 = false;
        
        for (int i = 1; i <= n; i++) {
            isDivisibleBy3 = i % 3 == 0;
            isDivisibleBy5 = i % 5 == 0;
            
            String val = "";
            if (isDivisibleBy3)
                val += "Fizz";
            if (isDivisibleBy5)
                val += "Buzz";
            if (val.equals(""))
                val += i;
            
            ans.add(val);
        }
        return ans;
    }
}