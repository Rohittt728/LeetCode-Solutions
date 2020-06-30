/*

Link : https://leetcode.com/problems/word-search-ii/

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:
Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]

Note:
All inputs are consist of lowercase letters a-z.
The values of words are distinct.

*/



class TrieNode {
    
    TrieNode next[] = new TrieNode[26];
    String word;
}

class Solution {
    
    int m, n;
    
    public List<String> findWords(char[][] board, String[] words) {
        
        m = board.length;
        n = board[0].length;
        
        List<String> ans = new ArrayList<>();
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, ans);
            }
        }
        return ans;
    }
    
    public TrieNode buildTrie(String[] words) {
        
        TrieNode root = new TrieNode();
        for (String word : words) {
            
            TrieNode p = root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> ans) {
        
        if (i < 0 || j < 0 || i >= m || j >= n)
            return;
        
        char ch = board[i][j];
        if (ch == '#' || p.next[ch - 'a'] == null)
            return;
        
        p = p.next[ch - 'a'];
        if (p.word != null) {
            ans.add(p.word);
            p.word = null;
        }
        
        board[i][j] = '#';
        
        dfs (board, i, j + 1, p, ans);
        dfs (board, i, j - 1, p, ans);
        dfs (board, i + 1, j, p, ans);
        dfs (board, i - 1, j, p, ans);
        
        board[i][j] = ch;
    }
}