using System.Collections.Generic;

public class BSTIterator
{
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root)
    {
        TreeNode tmp = root;
        while (tmp != null)
        {
            this.stack.Push(tmp);
            tmp = tmp.left;
        }
    }

    /** @return whether we have a next smallest number */
    public bool HasNext()
    {
        return this.stack.Count != 0;
    }

    /** @return the next smallest number */
    public int Next()
    {
        TreeNode treeNode = this.stack.Pop();
        if (treeNode.right != null)
        {
            TreeNode tmp = treeNode.right;
            while (tmp != null)
            {
                this.stack.Push(tmp);
                tmp = tmp.left;
            }
        }
        return treeNode.val;
    }
}
