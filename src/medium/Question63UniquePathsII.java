package medium;

public class Question63UniquePathsII {
    /*
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < m; j += 1) {
                if (i == 0) {
                    if (obstacleGrid[i][j] == 1 || (j >= 1 && result[i][j - 1] == 0)) {
                        result[i][j] = 0;
                    } else {
                        result[i][j] = 1;
                    }
                } else if (j == 0) {
                    if (obstacleGrid[i][j] == 1 || result[i - 1][j] == 0) {
                        result[i][j] = 0;
                    } else {
                        result[i][j] = 1;
                    }
                } else {
                    if (obstacleGrid[i][j] != 1) {
                        result[i][j] = result[i][j - 1] + result[i - 1][j];
                    } else {
                        result[i][j] = 0;
                    }
                }
            }
        }
        return result[n - 1][m - 1];
    }
    */
    // Cleaner
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][] {
                {0, 0},
                {0, 1}
        }));
    }
}
