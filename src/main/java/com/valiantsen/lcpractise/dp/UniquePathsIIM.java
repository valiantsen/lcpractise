package main.java.com.valiantsen.lcpractise.dp;

public class UniquePathsIIM {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (n == 0)
            return 0;

        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        } else {
            dp[0][0] = 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && obstacleGrid[i - 1][j] == 0 && obstacleGrid[i][j] == 0)
                    dp[i][j] += dp[i - 1][j];
                if (j > 0 && obstacleGrid[i][j - 1] == 0 && obstacleGrid[i][j] == 0)
                    dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
