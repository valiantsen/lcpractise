package main.java.com.valiantsen.lcpractise.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest
 * transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time Each transformed word must exist in the word list. Note
 * that beginWord is not a transformed word. For example,
 * 
 * Given: beginWord = "hit" endWord = "cog" wordList = ["hot","dot","dog","lot","log","cog"] Return
 * [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ] Note: Return an empty list
 * if there is no such transformation sequence. All words have the same length. All words contain
 * only lowercase alphabetic characters. You may assume no duplicates in the word list. You may
 * assume beginWord and endWord are non-empty and are not the same.
 * 
 * @ClassName: WordLadderIIH
 * @author zhangyasen
 * @date 2017年9月26日
 */
public class WordLadderIIH {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord))
            return result;
        Queue<String> queue = new LinkedList<>();
        return result;
    }
}
