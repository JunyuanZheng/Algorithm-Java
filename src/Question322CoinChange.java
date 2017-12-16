public class Question322CoinChange {
    /*
    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        return helper(coins, amount, new int[amount + 1]);
    }

    private int helper(int[] coins, int amount, int[] tmp) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (tmp[amount] != 0) {
            return tmp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i : coins) {
            int step = helper(coins, amount - i, tmp);
            if (step < 0)
                continue;
            min = Math.min(min, step + 1);
        }
        tmp[amount] = (min==Integer.MAX_VALUE) ? -1 : min;
        return tmp[amount];
    }
    */

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        int sum = 0;

        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Question322CoinChange test = new Question322CoinChange();
        System.out.println(test.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
