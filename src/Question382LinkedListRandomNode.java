import common.ListNode;

import java.util.Random;

public class Question382LinkedListRandomNode {
    class Solution {
        ListNode head;
        Random random;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        /** Returns a random node's value. */
        public int getRandom() {
            ListNode node = this.head;
            int value = node.val;
            for (int i = 1; node.next != null; i += 1) {
                node = node.next;
                if (this.random.nextInt(i + 1) == i) {
                    value = node.val;
                }
            }
            return value;
        }
    }
}
