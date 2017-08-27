import common.TreeNode;
import java.util.Stack;

public class Question129SumRootToLeafNumbers {
    public static int sumNumbers(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        int result = 0;
        if (root == null)
            return result;
        return helper(stringBuilder, root);
    }

    private static int helper(StringBuilder stringBuilder, TreeNode treeNode) {
        stringBuilder.append(treeNode.val);
        int result = 0;
        if (treeNode.left != null)
            result += helper(stringBuilder, treeNode.left);
        if (treeNode.right != null)
            result += helper(stringBuilder, treeNode.right);
        if (treeNode.left == null && treeNode.right == null)
            result += Integer.parseInt(stringBuilder.toString());
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        System.out.println(sumNumbers(t1));
    }
}
