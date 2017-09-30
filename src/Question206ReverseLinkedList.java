import common.ListNode;

import java.util.List;

public class Question206ReverseLinkedList {
    // Method 1: Iterate
    /*
    public static ListNode reverseList(ListNode head) {
        if (head == null) return head;
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
    */

    // Method 2: Recursive
    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode ddd = reverseList(l1);
        System.out.println(ddd);
    }

}
