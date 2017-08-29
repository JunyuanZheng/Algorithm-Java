import common.UndirectedGraphNode;

import java.util.*;

public class Question133CloneGraph {

    /*
    Method 1: DFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(new HashMap<>(), node);
    }

    private UndirectedGraphNode clone(HashMap<Integer, UndirectedGraphNode> hashMap, UndirectedGraphNode node) {
        if (node == null)
            return null;
        if (hashMap.containsKey(node.label))
            return hashMap.get(node.label);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        hashMap.put(node.label, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(clone(hashMap, neighbor));
        }
        return newNode;
    }
    */

    // Method 2: BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        HashMap<Integer, UndirectedGraphNode> hashMap = new HashMap<>();
        hashMap.put(newNode.label, newNode);
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode tmp = queue.poll();
            for (UndirectedGraphNode neighbor : tmp.neighbors) {
                if (!hashMap.containsKey(neighbor.label)) {
                    hashMap.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                hashMap.get(tmp.label).neighbors.add(hashMap.get(neighbor.label));
            }
        }
        return newNode;
    }

    public static void main(String[] args) {
        Question133CloneGraph test = new Question133CloneGraph();
        UndirectedGraphNode u0 = new UndirectedGraphNode(0);
        UndirectedGraphNode u1 = new UndirectedGraphNode(1);
        UndirectedGraphNode u2 = new UndirectedGraphNode(2);
        u0.neighbors.add(u1);
        u0.neighbors.add(u2);
        u1.neighbors.add(u2);
        u2.neighbors.add(u2);
        test.cloneGraph(u0);
    }
}
