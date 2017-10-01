public class Question209MinimumSizeSubarraySum {
    // Method1: O(N)
    /*
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < nums.length) {
            while (end < nums.length && sum < s) {
                sum += nums[end++];
            }
            if (sum < s)
                break;
            while (start < end && sum >= s) {
                sum -= nums[start++];
            }
            min = end - start + 1 < min ? end - start + 1 : min;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    */

    // Method 2: NLog(N)
    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i +=1 ) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sum.length; i++) {
            int end = binarySearch(sum, sum[i] + s, i + 1, sum.length - 1);
            if (end == sum.length)
                break;
            min = end - i < min ? end - i : min;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private int binarySearch(int[] sum, int val, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sum[mid] > val)
                high = mid - 1;
            else if (sum[mid] < val)
                low = mid + 1;
            else
                return mid;
        }
        return low;
    }

    public static void main(String[] args) {
        Question209MinimumSizeSubarraySum tmp = new Question209MinimumSizeSubarraySum();
        tmp.minSubArrayLen(4, new int[] {1, 4, 4});
    }
}
