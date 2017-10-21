import common.TreeNode;

public class Question235LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        Question235LowestCommonAncestorofaBinarySearchTree tmp = new Question235LowestCommonAncestorofaBinarySearchTree();
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        t1.right = t2;
        TreeNode abc = tmp.lowestCommonAncestor(t1, new TreeNode(1), new TreeNode(2));
        System.out.println(abc);
    }
}
