import java.util.ArrayList;
import java.util.Arrays;

public class Question350IntersectionOfTwoArrayII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> tmp = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1 += 1;
            } else {
                if (nums1[index1] > nums2[index2]) {
                    index2 += 1;
                } else {
                    tmp.add(nums1[index1]);
                    index1 += 1;
                    index2 += 1;
                }
            }
        }
        int[] result = new int[tmp.size()];
        int counter = 0;
        for (int i : tmp) {
            result[counter++] = i;
        }
        return result;
    }
}
