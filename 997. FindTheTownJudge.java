/*

Link : https://leetcode.com/problems/find-the-town-judge/

In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
If the town judge exists, then:

1. The town judge trusts nobody.
2. Everybody (except for the town judge) trusts the town judge.
3. There is exactly one person that satisfies properties 1 and 2.

You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

Example 1:
Input: N = 2, trust = [[1,2]]
Output: 2

Example 2:
Input: N = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:
Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1

Example 4:
Input: N = 3, trust = [[1,2],[2,3]]
Output: -1

Example 5:
Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3

Note:
1 <= N <= 1000
trust.length <= 10000
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N

*/


// Solution 1
class Solution {
    public int findJudge(int n, int[][] trust) {
        
        boolean knows[][] = new boolean[n][n];
        for (int a[] : trust)
            knows[a[0] - 1][a[1] - 1] = true;
        
        int left = 1;
        int right = n;
        while (left < right) {
            if (knows[left - 1][right - 1])
                left ++;
            else
                right --;
        }
        
        int cand = left;
        for (int i = 0; i < n; i++) {
            if (i+1 != cand && (!knows[i][cand - 1]) || knows[cand - 1][i])
                return -1;
        }
        return cand;
    }
}


// Solution 2 : more optimized
class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int knows[] = new int[n];
        for (int a[] : trust) {
            knows[a[0] - 1] --;
            knows[a[1] - 1] ++;
        }
        
        for (int i = 0; i < n; i++) {
            if (knows[i] == n - 1)
                return i + 1;
        }
        return -1;
    }
}