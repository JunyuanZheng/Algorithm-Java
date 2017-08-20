package medium;

public class Question75SortColors {
    public static void sortColors(int[] nums) {
        int p1 = -1;
        int p2 = -1;
        int p3 = -1;
        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] == 0) {
                nums[++p3] = 2;
                nums[++p2] = 1;
                nums[++p1] = 0;
            } else if (nums[i] == 1) {
                nums[++p3] = 2;
                nums[++p2] = 1;
            } else if (nums[i] == 2) {
                nums[++p3] = 2;
            }
        }
    }

    public static void main(String[] args) {
        sortColors(new int[] { 0, 1, 2, 1, 2, 2 });
    }
}
