using System;

class Question143ReorderList
{
    public static void ReorderList(ListNode head)
    {
        // A better method
        if (head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode important = slow; // The ListNode where separation start
        ListNode cur = slow.next; // The list node;

        while (cur != null && cur.next != null)
        {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = important.next;
            important.next = tmp;
        }

        ListNode p1 = head;
        ListNode p2 = important.next;

        while (p1 != important)
        {
            ListNode tmp = important.next;
            important.next = tmp.next;
            tmp.next = p1.next;
            p1.next = tmp;
            p1 = tmp.next;
        }
    }
}
