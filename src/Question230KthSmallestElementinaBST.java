import common.TreeNode;

public class Question230KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - count - 1);
        }
        return root.val;
    }


    private int countNodes(TreeNode n) {
        return n == null ? 0 : 1 + countNodes(n.left) + countNodes(n.right);
    }
}
