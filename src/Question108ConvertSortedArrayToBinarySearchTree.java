import common.TreeNode;

public class Question108ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        else
            return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int low, int high) {
        if (low > high)
            return null;

        int mid = low + (high - low) / 2;
        TreeNode tmp = new TreeNode(nums[mid]);
        tmp.left = helper(nums, low, mid - 1);
        tmp.right = helper(nums, mid + 1, high);

        return tmp;
    }
}
