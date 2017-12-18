import common.TreeNode;

public class Question337HouseRobberIII {
    /*
    public int rob(TreeNode root) {
        if (root == null)
            return 0;

        int val = root.val;

        if (root.left != null)
            val += rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            val += rob(root.right.left) + rob(root.right.right);

        return Math.max(val, rob(root.right) + rob(root.left));
    }
    */


    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
