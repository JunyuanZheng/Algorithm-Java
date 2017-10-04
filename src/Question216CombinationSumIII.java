import java.util.ArrayList;
import java.util.List;

public class Question216CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int k, int n, int min) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = min; i <= 9 && i <= n; i += 1) {
            list.add(i);
            helper(result, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Question216CombinationSumIII tmp = new Question216CombinationSumIII();
        System.out.println(tmp.combinationSum3(3, 9));
    }
}
