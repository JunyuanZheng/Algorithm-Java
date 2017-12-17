import java.util.Arrays;

public class Question338CountingBits {
    /*
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int newest = 0;
        for (int i = 1; i < result.length; i += 1) {
            if (isPowerOfTwo(i)) {
                newest = i;
                result[i] = 1;
            } else {
                result[i] = 1 + result[i - newest];
            }
        }
        return result;
    }

    private boolean isPowerOfTwo(int n) {
        return n>0 && (n&n-1)==0;
    }
    */
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    public static void main(String[] args) {
        Question338CountingBits test = new Question338CountingBits();
        System.out.println(Arrays.toString(test.countBits(5)));
    }
}
