import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question90SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; ) {
            int counter = 0;
            while (i + counter < nums.length && nums[i + counter] == nums[i]) {
                counter += 1;
            }
            int length = result.size();
            for (int j = 0; j < length; j += 1) {
                List<Integer> tmp = new ArrayList<>(result.get(j));
                for (int k = 0; k < counter; k += 1) {
                    tmp.add(nums[i]);
                    result.add(new ArrayList<>(tmp));
                }
            }
            i += counter;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {1, 2, 2}));
    }
}
