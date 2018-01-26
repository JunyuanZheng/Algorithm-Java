public class Question396RotateFunction {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int last = 0;
        for (int i = 0; i < A.length; i += 1) {
            last += i * A[i];
            sum += A[i];
        }
        int max = last;
        for (int i = A.length - 1; i >= 1; i -= 1) {
            last = last + sum - A.length * A[i];
            max = Math.max(max, last);
        }
        return max;
    }
}
