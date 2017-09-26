import common.ListNode;

public class Question203RemoveLinkedListElements {

    public ListNode RemoveElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preListNode = dummy;
        ListNode curListNode = dummy.next;
        while (curListNode != null) {
            if (curListNode.val == val) {
                preListNode.next = curListNode.next;
            } else {
                preListNode = preListNode.next;
            }
            curListNode = curListNode.next;
        }
        return dummy.next;
    }

}
