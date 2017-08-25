import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        helper(result, new ArrayList<>(), root, sum);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> tmp, TreeNode root, int sum) {
        if (root == null)
            return;
        if (root.right == null && root.left == null && root.val == sum) {
            tmp.add(root.val);
            result.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
        }
        tmp.add(root.val);
        helper(result, tmp, root.left, sum - root.val);
        helper(result, tmp, root.right, sum - root.val);
        tmp.remove(tmp.size() - 1);
    }
}
