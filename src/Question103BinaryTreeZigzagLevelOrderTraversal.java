import common.TreeNode;

import java.util.*;

public class Question103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null)
            return result;
        q.add(root);
        int level = 1;

        while (!q.isEmpty()) {
            int counter = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < counter; i += 1) {
                TreeNode t = q.poll();
                if (level % 2 == 0) {
                    l.add(0, t.val);
                } else {
                    l.add(t.val);
                }
                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);
            }
            level += 1;
            result.add(l);
        }
        return result;
    }

    public static void main(String[] args) {
        Question103BinaryTreeZigzagLevelOrderTraversal test = new Question103BinaryTreeZigzagLevelOrderTraversal();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        t2.right = t6;
        t3.left = t7;
        System.out.println(test.zigzagLevelOrder(t1));
    }
}
