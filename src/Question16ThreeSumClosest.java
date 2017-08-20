package medium;

import java.util.Arrays;

public class Question16ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int results = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i += 1) {
            int a = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int b = nums[start];
                int c = nums[end];
                if (a + b + c == target) {
                    return target;
                } else if (a + b + c < target) {
                    if (Math.abs(target - (a + b + c)) < Math.abs((long)(target - results))) {
                        results = a + b + c;
                    }
                    start += 1;
                } else {
                    if (Math.abs(target - (a + b + c)) < Math.abs((long)(target - results))) {
                        results = a + b + c;
                    }
                    end -= 1;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {0, 2, 1, -3}, 1));
    }
}
