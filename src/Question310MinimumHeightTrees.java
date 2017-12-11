import java.util.*;

public class Question310MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> tree = new ArrayList<>(n);
        for (int i = 0; i < n; i += 1) {
            tree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i += 1) {
            if (tree.get(i).size() == 1)
                leaves.add(i);
        }

        while (n > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = tree.get(i).iterator().next();
                tree.get(j).remove(i);
                if (tree.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            n -= leaves.size();
            leaves = newLeaves;
        }

        return leaves;
    }

    public static void main(String[] args) {
        Question310MinimumHeightTrees test = new Question310MinimumHeightTrees();
        test.findMinHeightTrees(4, new int[][] { {1, 0}, {1, 2}, {1, 3} });
    }
}
