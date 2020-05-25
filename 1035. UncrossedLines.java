/*

Link : https://leetcode.com/problems/uncrossed-lines/

We write the integers of A and B (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.

Example 1:
Input: A = [1,4,2], B = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.

Example 2:
Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
Output: 3

Example 3:
Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
Output: 2

Note:
1 <= A.length <= 500
1 <= B.length <= 500
1 <= A[i], B[i] <= 2000

*/



// Solution1 : Top down DP
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
     
        int alen = A.length;
        int blen = B.length;
        int dp[][] = new int[alen][blen];
        for (int i = 0; i < alen; i++) {
            for (int j = 0; j < blen; j++)
                dp[i][j] = -1;
        }
        
        return getMaxLines(A, B, 0, 0, dp);
    }
    
    public int getMaxLines(int a[], int b[], int i, int j, int dp[][]) {
        
        if (i == a.length || j == b.length)
            return 0;
        
        if (dp[i][j] != -1)
            return dp[i][j];
        
        if (a[i] == b[j])
            return dp[i][j] = 1 + getMaxLines(a, b, i + 1, j + 1, dp);
        else
            return dp[i][j] = Math.max(getMaxLines(a, b, i + 1, j, dp), getMaxLines(a, b, i, j + 1, dp));
    }
}


// Solution 2 : Bottom Up DP
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
     
        int alen = A.length;
        int blen = B.length;
        int dp[][] = new int[alen + 1][blen + 1];
        
        for (int i = alen - 1; i >= 0; i--) {
            for (int j = blen - 1; j >= 0; j--) {
                dp[i][j] = (A[i] == B[j]) ? (dp[i + 1][j + 1] + 1) : (Math.max(dp[i][j + 1], dp[i + 1][j]));
            }
        }
        
        return dp[0][0];
    }
}



// Solution 3 : Bottom up DP space optimized
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
     
        int alen = A.length;
        int blen = B.length;
        int dp[][] = new int[2][blen + 1];
        
        int f = 0;
        for (int i = alen - 1; i >= 0; i--) {
            for (int j = blen - 1; j >= 0; j--) {
                dp[f][j] = (A[i] == B[j]) ? (dp[f ^ 1][j + 1] + 1) : (Math.max(dp[f][j + 1], dp[f ^ 1][j]));
            }
            f = f ^ 1;
        }
        
        return dp[f ^ 1][0];
    }
}