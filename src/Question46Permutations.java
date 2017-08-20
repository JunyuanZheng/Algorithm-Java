package medium;

import java.util.ArrayList;
import java.util.List;

public class Question46Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), nums);
        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length)
            result.add(new ArrayList<>(temp));
        else {
            for (int i = 0; i < nums.length; i += 1) {
                // Important Step!!!
                if (temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                helper(result, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
