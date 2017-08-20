using System.Collections.Generic;

public class Question95UniqueBinarySearchTreesII
{
    public IList<TreeNode> GenerateTrees(int n)
    {
        if (n == 0)
            return new List<TreeNode>();
        else
            return helper(1, n);
    }

    private IList<TreeNode> helper(int start, int end)
    {
        IList<TreeNode> result = new List<TreeNode>();

        if (start > end)
        {
            result.Add(null);
            return result;
        }

        for (int i = start; i <= end; i += 1)
        {
            IList<TreeNode> left = helper(start, i - 1);
            IList<TreeNode> right = helper(i + 1, end);

            foreach (TreeNode t1 in left)
            {
                foreach (TreeNode t2 in right)
                {
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = t1;
                    tmp.right = t2;
                    result.Add(tmp);
                }
            }
        }

        return result;
    }
}