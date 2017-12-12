import java.util.Arrays;

public class Question313SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            //find next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j += 1) {
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
            }

            for (int j = 0; j < primes.length; j += 1) {
                if (primes[j] * ugly[idx[j]] == ugly[i]) {
                    idx[j] += 1;
                }
            }
        }

        return ugly[n - 1];
    }

    public static void main(String[] args) {
        Question313SuperUglyNumber tmp = new Question313SuperUglyNumber();
        tmp.nthSuperUglyNumber(2, new int[]{2, 3, 5});
    }
}
