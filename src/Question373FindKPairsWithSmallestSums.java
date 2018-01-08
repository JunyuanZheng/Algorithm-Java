import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Question373FindKPairsWithSmallestSums {
    // original solution
    /*
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> tmp = new PriorityQueue<>((a, b) -> b[0] + b[1] - a[0] - a[1]);
        for (int i : nums1) {
            for (int j : nums2) {
                tmp.offer(new int[]{i, j});
                if (tmp.size() > k) {
                    tmp.poll();
                }
            }
        }
        List<int[]> result = new ArrayList<>();
        result.addAll(tmp);
        return result;
    }
    */

    // better solution
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> tmp = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0)
            return res;
        for (int i = 0; i < nums1.length && i < k; i += 1) {
            tmp.offer(new int[] {nums1[i], nums2[0], 0});
        }
        while(k-- > 0 && !tmp.isEmpty()){
            int[] cur = tmp.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            tmp.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }


    public static void main(String[] args) {
        Question373FindKPairsWithSmallestSums tmp = new Question373FindKPairsWithSmallestSums();
        System.out.print(tmp.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }
}
