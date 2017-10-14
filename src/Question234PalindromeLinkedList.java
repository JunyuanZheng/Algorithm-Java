import common.ListNode;

public class Question234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next;
        while (slow != null) {
            if (slow.val != head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode tmp = dummy.next;
            dummy.next = cur.next;
            cur.next = cur.next.next;
            dummy.next.next = tmp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Question234PalindromeLinkedList tmp = new Question234PalindromeLinkedList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        System.out.println(tmp.isPalindrome(l1));
    }
}
