/*

Link : https://leetcode.com/problems/pascals-triangle/

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/



class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (numRows == 0)
            return ans;
        
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        ans.add(first);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }
}