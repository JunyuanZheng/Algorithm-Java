package easy;

public class Question69Sqrt {
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid > x / mid) {
                high = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2));
    }
}
