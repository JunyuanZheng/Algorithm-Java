package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question40CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), candidates, 0, target, 0);
        return result;
    }

    private static void helper(List<List<Integer>> input, List<Integer> temp, int[] candidates, int total, int target, int index) {
        if (target - total < 0)
            return;

        if (target - total == 0) {
            input.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i += 1) {
            // Important!!!
            if(i > index && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            helper(input, temp, candidates, total + candidates[i], target, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
