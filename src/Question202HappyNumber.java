public class Question202HappyNumber {
    public boolean IsHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(digitSquareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int digitSquareSum(int value) {
        int result = 0;
        while (value != 0) {
            int n = value % 10;
            result += (n * n);
            value /= 10;
        }
        return result;
    }
}
