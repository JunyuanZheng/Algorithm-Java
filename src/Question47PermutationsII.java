package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question47PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length)
            result.add(new ArrayList<>(temp));
        else {
            for(int i = 0; i < nums.length; i++){
                // Important Step
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                temp.add(nums[i]);
                helper(result, temp, nums, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }
}
