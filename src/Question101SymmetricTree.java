import common.TreeNode;

public class Question101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root != null)
            return helper(root.left, root.right);
        else
            return true;
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left != null && right != null && left.val == right.val) {
            return helper(left.left, right.right) && helper(left.right, right.left);
        } else if (left == null && right == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Question101SymmetricTree test = new Question101SymmetricTree();
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
        test.isSymmetric(t1);
    }
}
