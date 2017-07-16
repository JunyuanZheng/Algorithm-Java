package easy;

import common.TreeNode;

import java.util.*;

public class Question637AverageofLevelsinBinaryTree {
    /*
    Can be optimized
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        stack.push(root);
        double total = 0;
        int counter = 0;
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            counter += 1;
            total += treeNode.val;
            if (treeNode.left != null)
                temp.push(treeNode.left);
            if (treeNode.right != null)
                temp.push(treeNode.right);
            if (stack.isEmpty()) {
                list.add((double)total / counter);
                total = 0;
                counter = 0;
                stack = temp;
                temp = new Stack<>();
            }
        }
        return list;
    }
    */
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()) {
            // Critical
            int n = q.size();
            double sum = 0.0;
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(sum / n);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        System.out.println(averageOfLevels(t1));
    }
}
