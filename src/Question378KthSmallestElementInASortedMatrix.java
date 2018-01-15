import java.util.Comparator;
import java.util.PriorityQueue;

public class Question378KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j += 1) {
                pq.add(aMatrix[j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        Question378KthSmallestElementInASortedMatrix tmp = new Question378KthSmallestElementInASortedMatrix();
        System.out.print(tmp.kthSmallest(new int[][] {{ -5 }}, 1));
    }
}
