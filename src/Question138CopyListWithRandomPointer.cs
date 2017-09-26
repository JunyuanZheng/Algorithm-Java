using System;
using System.Collections.Generic;

class Question138CopyListWithRandomPointer
{
    public static RandomListNode CopyRandomList(RandomListNode head)
    {
        if (head == null) return head;
        Dictionary<RandomListNode, RandomListNode> dictionary = new Dictionary<RandomListNode, RandomListNode>();

        // First Iteration
        RandomListNode node = head;
        while (node != null)
        {
            dictionary.Add(node, new RandomListNode(node.label));
            node = node.next;
        }

        node = head;
        while (node != null)
        {
            if (node.next != null)
                dictionary[node].next = dictionary[node.next];
            else
                dictionary[node].next = null;

            if (node.random != null)
                dictionary[node].random = dictionary[node.random];
            else
                dictionary[node].random = null;

            node = node.next;
        }

        return dictionary[head];
    }
}
