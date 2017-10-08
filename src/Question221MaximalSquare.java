public class Question221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int result = Integer.MIN_VALUE;
        // Important!
        int[][] ints = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i += 1) {
            for (int j = 1; j < n + 1; j += 1) {
                if (matrix[i - 1][j - 1] == '1') {
                    ints[i][j] = Math.min(Math.min(ints[i][j-1] , ints[i-1][j-1]), ints[i-1][j]) + 1;
                    result = Math.max(ints[i][j], result);
                }
            }
        }
        return result * result;
    }
}
