class Question142LinkedListCycleII
{
    public ListNode DetectCycle(ListNode head)
    {
        if (head == null) return head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
            {
                ListNode tmpListNode = head;
                while(tmpListNode != slow)
                {
                    tmpListNode = tmpListNode.next;
                    slow = slow.next;
                }
                return tmpListNode;
            }
        }

        return null;
    }
}
