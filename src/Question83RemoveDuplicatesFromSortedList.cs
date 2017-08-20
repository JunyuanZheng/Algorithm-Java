public class Question83RemoveDuplicatesFromSortedList
{
	public static ListNode DeleteDuplicates(ListNode head)
	{
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode pointer = new ListNode(head.val);
        dummy.next = pointer;
        while (head != null)
        {
            if (head.val != pointer.val)
            {
                pointer.next = new ListNode(head.val);
                pointer = pointer.next;
            }
            head = head.next;
        }
        return dummy.next;
	}
}