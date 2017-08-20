package easy;

// 二次方程求根公式
public class Question411ArrangingCoins {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }
}
