package easy;

import common.ListNode;

public class Question21MergeTwoSortedLists {
    // Method 1
    /*
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pointer0 = dummy;
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        while (pointer1 != null || pointer2 != null) {
            if (pointer1 != null && pointer2 != null) {
                if (pointer1.val <= pointer2.val) {
                    pointer0.next = pointer1;
                    pointer1 = pointer1.next;
                } else {
                    pointer0.next = pointer2;
                    pointer2 = pointer2.next;
                }
            } else if (pointer1 == null) {
                pointer0.next = pointer2;
                pointer2 = pointer2.next;
            } else {
                pointer0.next = pointer1;
                pointer1 = pointer1.next;
            }
            pointer0 = pointer0.next;
        }
        return dummy.next;
    }
    */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode mergedHead;

        if (l1.val <= l2.val) {
            mergedHead = l1;
            mergedHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mergedHead = l2;
            mergedHead.next = mergeTwoLists(l1, l2.next);
        }

        return mergedHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(7);
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        mergeTwoLists(l1, l5);
    }
}
