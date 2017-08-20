package easy;

public class Question7ReverseInteger {
    public static int reverse(int x) {
        int result = 0;
        while (Math.abs(x) > 0) {
            int newResult = result * 10 + x % 10;
            // Important Check Overflow
            if ((newResult - x % 10) / 10 != result)
                return 0;
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
