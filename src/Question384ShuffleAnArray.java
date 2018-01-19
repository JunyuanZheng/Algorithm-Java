import java.util.Random;

public class Question384ShuffleAnArray {
    class Solution {
        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return this.nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int[] tmp = this.nums.clone();
            for(int j = 1; j < tmp.length; j++) {
                int i = random.nextInt(j + 1);
                swap(tmp, i, j);
            }
            return tmp;
        }

        private void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}
