import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        helper(result, "", root);
        return result;
    }

    private void helper (List<String> result, String tmp, TreeNode root) {
        if (root.right == null && root.left == null) {
            result.add(tmp + root.val);
            return;
        }
        if (root.right != null)
            helper(result, tmp + root.val + "->", root.right);
        if (root.left != null)
            helper(result, tmp + root.val + "->", root.left);
    }

    public static void main(String[] args) {
        Question257BinaryTreePaths tmp = new Question257BinaryTreePaths();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(30);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.right = t5;
        System.out.println(tmp.binaryTreePaths(t1));
    }
}
