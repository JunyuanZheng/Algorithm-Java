public class Question397IntegerReplacement {
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        else if (n == Integer.MAX_VALUE) return 32;
        else if (n % 2 == 0) return 1 + integerReplacement(n / 2);
        else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) return 1 + integerReplacement(n - 1);
        else return 1 + integerReplacement(n + 1);
    }
}
