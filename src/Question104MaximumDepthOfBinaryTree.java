import common.TreeNode;

public class Question104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }
}
