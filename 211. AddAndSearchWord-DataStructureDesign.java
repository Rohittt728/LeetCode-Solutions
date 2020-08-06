/*

Link : https://leetcode.com/problems/add-and-search-word-data-structure-design/

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.

*/



class WordDictionary {

    /** Initialize your data structure here. */
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        int len = word.length();
        
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.item = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return findWord(word, 0, root);
    }
    
    public boolean findWord(String word, int k, TrieNode node) {
        if (k == word.length())
            return !node.item.equals("");
        
        char c = word.charAt(k);
        if (c != '.')
            return node.children[c - 'a'] != null && findWord(word, k + 1, node.children[c - 'a']);
        
        else {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (findWord(word, k + 1, node.children[i]))
                        return true;
                }
            }
        }
        return false;
    }
}

public class TrieNode {
    TrieNode children[] = new TrieNode[26];
    String item = "";
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */