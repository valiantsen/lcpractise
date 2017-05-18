package main.java.com.valiantsen.lcpractise.backtrack;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * 
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * @ClassName: WordSearchM
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月18日
 */
public class WordSearchM {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == words[0] && existNext(board, words, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existNext(char[][] board, char[] words, boolean[][] visited, int x, int y, int count) {
        if (count == words.length) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[x].length || visited[x][y]) {
            return false;
        }
        if (board[x][y] == words[count]) {
            visited[x][y] = true;
            if (existNext(board, words, visited, x + 1, y, count + 1)
                    || existNext(board, words, visited, x - 1, y, count + 1)
                    || existNext(board, words, visited, x, y + 1, count + 1)
                    || existNext(board, words, visited, x, y - 1, count + 1)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
    public static void main(String[] args) {
        boolean[][] a = new boolean[2][2];
        System.out.println(a[1][1]);
    }
}
