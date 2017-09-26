package main.java.com.valiantsen.lcpractise.array;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You
 * may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 11110 11010 11000 00000 Answer: 1
 * 
 * Example 2:
 * 
 * 11000 11000 00100 00011 Answer: 3
 * 
 * @ClassName: NumberOfIslandsM
 * @author zhangyasen
 * @date 2017年9月21日
 */
public class NumberOfIslandsM {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        if (grid[0].length == 0)
            return 0;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);
    }
}