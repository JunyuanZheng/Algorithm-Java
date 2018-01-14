public class Question377CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] tmp = new int[target + 1];
        tmp[0] = 1;
        for (int i = 1; i < tmp.length; i += 1) {
            for (int num : nums) {
                if (i - num >= 0) {
                    tmp[i] += tmp[i - num];
                }
            }
        }
        return tmp[target];
    }
}
