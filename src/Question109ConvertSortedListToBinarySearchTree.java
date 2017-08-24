import common.ListNode;
import common.TreeNode;

public class Question109ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == tail)
            return null;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode tmp = new TreeNode(slow.val);
        tmp.left = helper(head, slow);
        tmp.right = helper(slow.next, tail);
        return tmp;
    }
}
