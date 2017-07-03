package medium;

import java.util.*;

// https://en.wikipedia.org/wiki/3SUM
// How to check duplicate lists https://stackoverflow.com/questions/1075656/simple-way-to-find-if-two-different-lists-contain-exactly-the-same-elements
public class Question15ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i += 1) {
            // Important!
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int b = nums[start];
                int c = nums[end];
                if (a + b + c == 0) {
                    results.add(Arrays.asList(a, b, c));
                    // Important!
                    start += 1;
                    end -= 1;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start += 1;
                    }
                    while (start < end && nums[end] == nums[end + 1]) {
                        end -= 1;
                    }
                } else if (a + b + c > 0) {
                    end -= 1;
                } else {
                    start += 1;
                }
            }
        }
        return results;
    }

    public static void main(String args[]) {
        System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }
}
