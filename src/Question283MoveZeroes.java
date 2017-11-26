public class Question283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int counter = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[counter++] = num;
            }
        }
        for (int i = counter; i < nums.length; i += 1) {
            nums[i] = 0;
        }
    }
}
