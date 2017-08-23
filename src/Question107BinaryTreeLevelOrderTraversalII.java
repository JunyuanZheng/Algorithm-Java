import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question107BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        List<TreeNode> tmp = new ArrayList<>();
        tmp.add(root);
        while (!tmp.isEmpty()) {
            int counter = tmp.size();
            List<Integer> r = new ArrayList<>();
            for (int i = 0; i < counter; i += 1) {
                TreeNode t = tmp.get(0);
                tmp.remove(0);
                r.add(t.val);
                if (t.left != null)
                    tmp.add(t.left);
                if (t.right != null)
                    tmp.add(t.right);
            }
            result.add(0, r);
        }
        return result;
    }
}
