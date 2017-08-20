import common.ListNode;

public class Question92ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;

        for (int i = 0; i < m - 1; i += 1) {
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode then = start.next;

        // Important!
        for (int i = 0; i < n - m; i += 1) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
