import java.util.ArrayList;
import java.util.List;

public class Question228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0)
            return list;
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i += 1) {
            if (Math.abs(nums[i] - end) > 1) {
                if (start != end) {
                    list.add(start + "->" + end);
                } else {
                    list.add(Integer.toString(start));
                }
                start = nums[i];
            }
            end = nums[i];
        }
        if (start == end) {
            list.add(Integer.toString(start));
        } else {
            list.add(start + "->" + end);
        }
        return list;
    }

    // A better one
    /*
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList();
        if (nums.length == 1) {
            list.add(nums[0] + "");
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1) {
                i++;
            }
            if (a != nums[i]) {
                list.add(a + "->" + nums[i]);
            } else {
                list.add(a + "");
            }
        }
        return list;
    }
    */

    public static void main(String[] args) {
        Question228SummaryRanges tmp = new Question228SummaryRanges();
        System.out.println(tmp.summaryRanges(new int[]{-2147483648,-2147483647,2147483647}));
    }
}
