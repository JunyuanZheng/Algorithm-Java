public class Question238ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i += 1) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int tmp = 1;
        for (int i = nums.length - 1; i >= 0; i -= 1) {
            result[i] = tmp * result[i];
            tmp = tmp * nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Question238ProductofArrayExceptSelf tmp = new Question238ProductofArrayExceptSelf();
        tmp.productExceptSelf(new int[] {1, 0});
    }
}
