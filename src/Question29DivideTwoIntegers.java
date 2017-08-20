package medium;

// http://www.programcreek.com/2014/05/leetcode-divide-two-integers-java/
public class Question29DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        long pDividend = Math.abs((long) dividend);
        long pDivisor = Math.abs((long) divisor);
        int result = 0;

        while (pDividend >= pDivisor) {
            int shift = 0;
            while (pDividend >= (pDivisor << shift)) {
                shift += 1;
            }
            result += 1 << (shift - 1);
            pDividend -= pDivisor << (shift - 1);
        }

        // Trap!!!
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return result;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
        System.out.println(divide(50, 2));
    }
}
