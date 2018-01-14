public class Question376WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int index = 0;
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index += 1;
        }
        if (index == nums.length - 1) {
            return 1;
        }
        // direct = true means we are going up, direct = false means we are going down
        int counter = 2;
        boolean direction = nums[index + 1] - nums[index] > 0;
        for (int i = index + 1; i < nums.length - 1; i += 1) {
            if (direction && nums[i + 1] < nums[i]) {
                nums[counter] = nums[i + 1];
                counter += 1;
                direction = false;
            } else if (!direction && nums[i + 1] > nums[i]) {
                nums[counter] = nums[i + 1];
                counter += 1;
                direction = true;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Question376WiggleSubsequence tmp = new Question376WiggleSubsequence();
        System.out.println(tmp.wiggleMaxLength(new int[] {0, 0}));
    }
}
