/*

Link : https://leetcode.com/problems/implement-trie-prefix-tree/

Implement a trie with insert, search, and startsWith methods.

Example:
Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

Note:
You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

*/



class TrieNode {
    
    private TrieNode links[];
    private int R = 26;
    private boolean isEnd;
    
    public TrieNode() {
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }
    
    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }
    
    public boolean getIsEnd() {
        return isEnd;
    }
}

class Trie {
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode node = root;
        int len = word.length();
        
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch))
                node.put(ch, new TrieNode());
            
            node = node.get(ch);
        }
        node.setIsEnd(true);
    }
    
    public TrieNode searchPrefix(String word) {
        
        TrieNode node = root;
        int len = word.length();
        
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            
            if (!node.containsKey(ch))
                return null;
            node = node.get(ch);
        }
        return node;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode node = searchPrefix(word);
        return node != null && node.getIsEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */