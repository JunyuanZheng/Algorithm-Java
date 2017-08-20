import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> tmp = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !tmp.isEmpty()) {
            while (cur != null) {
                tmp.add(cur);
                cur = cur.left;
            }
            cur = tmp.pop();
            result.add(cur.val);
            cur = cur.right;
        }

        return result;
    }
}
