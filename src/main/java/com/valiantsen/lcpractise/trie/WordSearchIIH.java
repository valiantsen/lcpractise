package main.java.com.valiantsen.lcpractise.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells
 * are those horizontally or vertically neighboring. The same letter cell may not be used more than
 * once in a word.
 * 
 * For example, Given words = ["oath","pea","eat","rain"] and board =
 * 
 * [ ['o','a','a','n'], ['e','t','a','e'], ['i','h','k','r'], ['i','f','l','v'] ] Return
 * ["eat","oath"]. Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @ClassName: WordSearchIIH
 * @author zhangyasen
 * @date 2017年10月15日
 */
public class WordSearchIIH {
    private TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0)
            return result;
        root = new TrieNode(null);
        for (String word : words) {
            insert(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.nexts[board[i][j] - 'a'] != null) {
                    dfs(root, result, "", i, j, board, visited);
                }
            }
        }
        return result;
    }

    private void dfs(TrieNode root, List<String> result, String temp, int x, int y, char[][] board,
            boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y])
            return;
        char letter = board[x][y];
        if (root.nexts[letter - 'a'] == null)
            return;
        if (root.nexts[letter - 'a'] != null) {
            temp += letter;
            if (root.nexts[letter - 'a'].isEnd) {
                if (!result.contains(temp)) {
                    result.add(new String(temp));
                }
            }
            visited[x][y] = true;
            root = root.nexts[letter - 'a'];
            dfs(root, result, temp, x + 1, y, board, visited);
            dfs(root, result, temp, x - 1, y, board, visited);
            dfs(root, result, temp, x, y + 1, board, visited);
            dfs(root, result, temp, x, y - 1, board, visited);
            temp = temp.substring(0, temp.length() - 1);
            visited[x][y] = false;

        }
        return;
    }

    private void insert(String word) {
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
