/*

Link : https://leetcode.com/problems/unique-binary-search-trees/

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:
Input: 3
Output: 5

Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/



// Solution 1 Logic Explained

// G(n) -> No. of unique BST's for length n
// G(n) = F(1,n) + F(2, n) + ...... + F(n, n)
// F(i, n) -> No. of BST's with i as the root
// F(1,n) = trees with root 1 = left tree * right tree = G(0) * G(n - 1)
// F(2,n) = trees with root 2 = left tree * right tree = G(1) * G(n - 2)

// G(n) = G(0) * G(n - 1) + G(1) * G(n - 2) + ...... + G(n - 1) * G(n - n)

class Solution {
    public int numTrees(int n) {
        
        int G[] = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                G[i] = G[i] + (G[j - 1] * G[i - j]);
        }
        return G[n];
    }
}
 


// Solution 2 : We can also directly use Catalan number