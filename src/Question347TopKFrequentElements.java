import java.util.*;

public class Question347TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> tmp = new HashMap<>();
        for (int i : nums) {
            if (tmp.containsKey(i)) {
                tmp.put(i, tmp.get(i) + 1);
            } else {
                tmp.put(i, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : tmp.entrySet()) {
            priorityQueue.offer(entry);
            if(priorityQueue.size() > k)
                priorityQueue.poll();
        }

        List<Integer> result = new ArrayList<>();
        while(!priorityQueue.isEmpty()) {
            result.add(0, priorityQueue.poll().getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        Question347TopKFrequentElements tmp = new Question347TopKFrequentElements();
        System.out.println(tmp.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
