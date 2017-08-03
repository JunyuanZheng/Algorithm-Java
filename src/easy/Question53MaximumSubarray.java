package easy;

public class Question53MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int[] result = new int[nums.length];
        if (nums.length == 0)
            return 0;
        result[0] = nums[0];
        int maxResult = nums[0];
        for (int i = 1; i < nums.length; i += 1) {
            result[i] = Math.max(nums[i], result[i - 1] + nums[i]);
            maxResult = Math.max(maxResult, result[i]);
        }
        return maxResult;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
