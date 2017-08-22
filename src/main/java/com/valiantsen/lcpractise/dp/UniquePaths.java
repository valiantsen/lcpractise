package main.java.com.valiantsen.lcpractise.dp;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @ClassName: UniquePaths
 * @author zhangyasen
 * @date 2017年8月22日
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i < m + 1; i++)
            for (int j = 1; j < n + 1; j++) {
                if (i > 1)
                    dp[i][j] += dp[i - 1][j];
                if (j > 1)
                    dp[i][j] += dp[i][j - 1];
            }

        return dp[m][n];
    }
}
