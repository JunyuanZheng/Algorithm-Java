public class Question100SameTree
{
	public bool IsSameTree(TreeNode p, TreeNode q)
	{
        if (p != null && q != null && p.val == q.val)
            return IsSameTree(p.right, q.right) && IsSameTree(p.left, q.left);
        else if (p == null && q == null)
            return true;
        else
            return false;
	}
}
