public class Question303RangeSumQueryImmutable {
    class NumArray {
        int[] nums;
        public NumArray(int[] nums) {
            for (int i = 1; i < nums.length; i += 1) {
                nums[i] += nums[i - 1];
            }
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return this.nums[j];
            }
            return this.nums[j] - this.nums[i - 1];
        }
    }
}
