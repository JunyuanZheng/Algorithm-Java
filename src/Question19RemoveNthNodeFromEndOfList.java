package medium;

import common.ListNode;

// Two Methods:
// 1 Pass
// 2 Pass
public class Question19RemoveNthNodeFromEndOfList {
    // Method 1: 2 Pass
    /*
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        int length = 0;
        while (first != null) {
            length += 1;
            first = first.next;
        }
        int i = 0;
        first = dummy;
        while (i < length - n) {
            first = first.next;
            i += 1;
        }
        first.next = first.next.next;
        return dummy.next;
    }
    */

    // 1 Pass
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        int length = 0;
        while (length <= n) {
            length += 1;
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode listNode = removeNthFromEnd(l1, 3);
    }
}
