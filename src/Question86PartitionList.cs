public class Question86PartionList
{
	public ListNode Partition(ListNode head, int x)
	{
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        while (head != null)
        {
            if (head.val < x)
            {
                p1.next = new ListNode(head.val);
                p1 = p1.next;
			}
            else
            {
				p2.next = new ListNode(head.val);
				p2 = p2.next;
            }
            head = head.next;
        }
        p1.next = dummy2.next;
        return dummy1.next;
	}
}