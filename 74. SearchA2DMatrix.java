/*

Link : https://leetcode.com/problems/search-a-2d-matrix/

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
Output: false

Example 3:
Input: matrix = [], target = 0
Output: false

Constraints:
m == matrix.length
n == matrix[i].length
0 <= m, n <= 100
-104 <= matrix[i][j], target <= 104

*/

// Solution 1 : Brute Force
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        for (i = 0; i < m; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][n - 1])
                break;
        }
        
        if (i < m) {
            for (int j = 0; j < n; j++) {
                if (target == matrix[i][j])
                    return true;
            }
        }
        
        return false;
    }
}


// Solution 2 : Binary Search
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        int j = m * n - 1;
        
        while (i <= j) {
            int mid = (i + j) / 2;
            
            int p = mid / n;
            int q = mid % n;
            
            if (matrix[p][q] == target)
                return true;
            
            if (matrix[p][q] < target)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return false;
    }
}