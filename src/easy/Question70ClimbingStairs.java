package easy;

public class Question70ClimbingStairs {
    public static int climbStairs(int n) {
        int a1 = 1;
        int a2 = 2;
        if (n < 3)
            return n;
        int sum = 0;
        for (int i = 3; i <= n; i += 1) {
            sum = a1 + a2;
            a1 = a2;
            a2 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
