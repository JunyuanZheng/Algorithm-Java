import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        List<TreeNode> tmp = new ArrayList<>();
        tmp.add(root);
        while (!tmp.isEmpty()) {
            int counter = tmp.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < counter; i += 1) {
                TreeNode t = tmp.get(0);
                if (t.left != null)
                    tmp.add(t.left);
                if (t.right != null)
                    tmp.add(t.right);
                level.add(t.val);
                tmp.remove(0);
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        Question102BinaryTreeLevelOrderTraversal test = new Question102BinaryTreeLevelOrderTraversal();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        t2.right = t6;
        t3.left = t7;
        System.out.println(test.levelOrder(t1));
    }

}
