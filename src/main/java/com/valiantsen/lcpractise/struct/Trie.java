package main.java.com.valiantsen.lcpractise.struct;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @ClassName: Trie
 * @author zhangyasen
 * @date 2017年10月2日
 */
public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(null);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode pointer = root;
        for (Character letter : word.toCharArray()) {
            if (pointer.nexts[letter - 'a'] == null) {
                TrieNode newNode = new TrieNode(letter);
                pointer.nexts[letter - 'a'] = newNode;
            }
            pointer = pointer.nexts[letter - 'a'];
        }
        pointer.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode pointer = root;
        for (Character letter : word.toCharArray()) {
            if (pointer.nexts[letter - 'a'] == null)
                return false;
            pointer = pointer.nexts[letter - 'a'];
        }
        return pointer.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode pointer = root;
        for (Character letter : prefix.toCharArray()) {
            if (pointer.nexts[letter - 'a'] == null)
                return false;
            pointer = pointer.nexts[letter - 'a'];
        }
        return true;
    }

    public class TrieNode {
        public Character letter;

        public TrieNode[] nexts;

        public boolean isEnd;

        public TrieNode(Character letter) {
            this.letter = letter;
            nexts = new TrieNode[26];
            isEnd = false;
        }
    }
}
