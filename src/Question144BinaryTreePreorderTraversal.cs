using System.Collections.Generic;

class Question144BinaryTreePreorderTraversal
{
    public IList<int> PreorderTraversal(TreeNode root)
    {
        IList<int> result = new List<int>();
        Stack<TreeNode> rightTreeStack = new Stack<TreeNode>();

        while (root != null)
        {
            result.Add(root.val);
            if (root.right != null)
            {
                rightTreeStack.Push(root.right);
            }
            root = root.left;
            if (root == null && rightTreeStack.Count != 0)
            {
                root = rightTreeStack.Pop();
            }
        }

        return result;
    }
}
