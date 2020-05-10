/*

Link : https://leetcode.com/problems/spiral-matrix/

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

*/


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new ArrayList<Integer>();
        
        int m = matrix.length;
        if (m == 0)
            return ans;
        
        int n = matrix[0].length;
        
        int r1 = 0;
        int r2 = m - 1;
        int c1 = 0;
        int c2 = n - 1;
        
        while (r1 <= r2 && c1 <= c2) {
            for (int j = c1; j <= c2; j++)
                ans.add(matrix[r1][j]);
            for (int i = r1 + 1; i <= r2; i++)
                ans.add(matrix[i][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int j = c2 - 1; j >= c1; j--)
                    ans.add(matrix[r2][j]);
                for (int i = r2 - 1; i > r1; i--)
                    ans.add(matrix[i][c1]);
            }
            r1 ++;
            r2 --;
            c1 ++;
            c2 --;
        }
        return ans;
    }
}