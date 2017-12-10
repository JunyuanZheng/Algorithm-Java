public class Question307RangeSumQueryMutable {
    /* ETL
    class NumArray {
        int[] result;
        int[] nums;
        public NumArray(int[] nums) {
            this.nums = nums.clone();
            for (int i = 1; i < nums.length; i += 1) {
                nums[i] += nums[i - 1];
            }
            this.result = nums.clone();
        }

        public void update(int i, int val) {
            int diff = this.nums[i] - val;
            for (int j = i; j < this.nums.length; j += 1) {
                this.result[j] -= diff;
            }
            this.nums[i] = val;
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return this.result[j];
            }
            return this.result[j] - this.result[i - 1];
        }
    }
     */

    class NumArray {
        int[] nums;
        int[] BIT;
        int n;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
            this.BIT = new int[n + 1];
            for (int i = 0; i < n; i += 1) {
                init(i, nums[i]);
            }
        }

        public void init(int i, int val) {
            i++;
            while (i <= this.n) {
                this.BIT[i] += val;
                i += (i & -i);
            }
        }

        void update(int i, int val) {
            int diff = val - nums[i];
            nums[i] = val;
            init(i, diff);
        }

        public int getSum(int i) {
            int sum = 0;
            i++;
            while (i > 0) {
                sum += BIT[i];
                i -= (i & -i);
            }
            return sum;
        }

        public int sumRange(int i, int j) {
            return getSum(j) - getSum(i - 1);
        }
    }
}
