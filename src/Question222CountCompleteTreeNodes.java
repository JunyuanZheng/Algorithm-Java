import common.TreeNode;

public class Question222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        if (leftHeight == rightHeight)
            return (1 << leftHeight) - 1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftHeight(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth += 1;
            root = root.left;
        }
        return depth;
    }

    private int rightHeight(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth += 1;
            root = root.right;
        }
        return depth;
    }
}
