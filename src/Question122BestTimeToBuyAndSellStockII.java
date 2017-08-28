package common;

public class Question122BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i += 1) {
            result += (prices[i] > prices[i - 1]) ? prices[i] - prices[i - 1] : 0;
        }
        return result;
    }
}
