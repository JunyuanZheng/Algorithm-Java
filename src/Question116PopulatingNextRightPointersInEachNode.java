import common.TreeLinkNode;

public class Question116PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        TreeLinkNode startNode = root;
        while (startNode != null) {
            TreeLinkNode cur = startNode;
            while (cur != null) {
                if (cur.left != null)
                    cur.left.next = cur.right;
                if (cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            startNode = startNode.left;
        }
    }
}
