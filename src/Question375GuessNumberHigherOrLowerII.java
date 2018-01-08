public class Question375GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(1, n, dp);
    }

    private int helper(int low, int high, int[][] dp) {
        if (low >= high) return 0;
        if (dp[low][high] != 0)
            return dp[low][high];
        int min = Integer.MAX_VALUE;
        for (int i = low; i <= high; i += 1) {
            min = Math.min(min, Math.max(helper(low, i - 1, dp), helper(i + 1, high, dp)) + i);
        }
        dp[low][high] = min;
        return min;
    }

    public static void main(String[] args) {
        Question375GuessNumberHigherOrLowerII tmp = new Question375GuessNumberHigherOrLowerII();
        tmp.getMoneyAmount(4);
    }
}
