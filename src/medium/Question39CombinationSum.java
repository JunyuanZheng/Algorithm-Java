package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question39CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        helper(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    public static void helper(List<List<Integer>> input, List<Integer> temp, int[] candidates, int target, int start) {
        if (target < 0)
            return;
        if (target == 0) {
            input.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i += 1) {
            temp.add(candidates[i]);
            helper(input, temp, candidates, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[] {2, 3, 6, 7}, 7);
    }
}
