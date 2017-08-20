package easy;

public class Question26RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int length;
        if (nums.length > 1) {
            int last = nums[0];
            length = 1;
            for (int i = 1; i < nums.length; i += 1) {
                if (nums[i] != last) {
                    nums[length] = nums[i];
                    length += 1;
                    last = nums[i];
                }
            }
        } else {
            return nums.length;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1, 1, 2}));
    }
}
