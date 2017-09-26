package main.java.com.valiantsen.lcpractise.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of
 * shortest transformation sequence from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time. Each transformed word must exist in the word list. Note
 * that beginWord is not a transformed word. For example,
 * 
 * Given: beginWord = "hit" endWord = "cog" wordList = ["hot","dot","dog","lot","log","cog"] As one
 * shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * 
 * Note: Return 0 if there is no such transformation sequence. All words have the same length. All
 * words contain only lowercase alphabetic characters. You may assume no duplicates in the word
 * list. You may assume beginWord and endWord are non-empty and are not the same. UPDATE
 * (2017/1/20): The wordList parameter had been changed to a list of strings (instead of a set of
 * strings). Please reload the code definition to get the latest changes.
 * 
 * @ClassName: WordLadderM
 * @author zhangyasen
 * @date 2017年9月26日
 */
public class WordLadderM {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String word = queue.poll();
                if (endWord.equals(word)) {
                    return count;
                }
                Iterator<String> iterator = wordList.iterator();
                while (iterator.hasNext()) {
                    String leftWord = iterator.next();
                    if (isAdjacent(word, leftWord)) {
                        queue.add(leftWord);
                        iterator.remove();
                    }
                }
            }


        }
        return 0;
    }

    private boolean isAdjacent(String st, String nd) {
        int counter = 0;
        for (int i = 0; i < st.length() && i < nd.length(); i++) {
            if (st.charAt(i) != nd.charAt(i)) {
                counter++;
            }
        }
        return counter == 1;
    }

    /**
     * "hit" "cog" ["hot","dot","dog","lot","log"] TODO
     * 
     * @param args
     */
    public static void main(String[] args) {
        WordLadderM wl = new WordLadderM();
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        wl.ladderLength("hit", "cog", wordList);
    }
}
