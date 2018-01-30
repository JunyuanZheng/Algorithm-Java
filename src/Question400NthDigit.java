public class Question400NthDigit {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > count * len) {
            n -= count * len;
            count *= 10;
            start *= 10;
            len += 1;
        }

        start += (n - 1) / len;
        String number = Integer.toString(start);
        return Character.getNumericValue(number.charAt((n - 1) % len));
    }
}
