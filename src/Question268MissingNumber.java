public class Question268MissingNumber {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = (length) * (length + 1) / 2;
        for (int i : nums) {
            sum -= i;
        }
        return sum;
    }

    /*
    XOR
     */
    /*
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
    */
}
