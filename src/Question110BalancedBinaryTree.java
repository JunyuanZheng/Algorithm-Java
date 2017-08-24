import common.TreeNode;

public class Question110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
