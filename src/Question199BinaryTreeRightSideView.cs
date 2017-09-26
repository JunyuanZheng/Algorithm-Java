using System;
using System.Collections.Generic;
using System.Linq;

class Question199BinaryTreeRightSideView
{
    public IList<int> RightSideView(TreeNode root)
    {
        IList<int> result = new List<int>();
        Queue<TreeNode> queue = new Queue<TreeNode>();
        if (root != null)
            queue.Enqueue(root);
        _helper(result, queue);
        return result;
    }

    private void _helper(IList<int> result, Queue<TreeNode> queue)
    {
        int counter = queue.Count;
        if (counter == 0) return;
        result.Add(queue.Last().val);
        for (int i = 0; i < counter; i += 1)
        {
            TreeNode treeNode = queue.Dequeue();
            if (treeNode.left != null)
                queue.Enqueue(treeNode.left);
            if (treeNode.right != null)
                queue.Enqueue(treeNode.right);
        }
        _helper(result, queue);
    }
}
