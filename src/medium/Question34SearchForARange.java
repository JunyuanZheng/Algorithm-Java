package medium;

public class Question34SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0)
            return result;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        if (nums[low] == target)
            result[0] = low;
        else
            return result;

        high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2 + 1;
            if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid;
        }
        result[1] = high;
        return result;
    }

    public static void main(String[] args) {
        int[] result = searchRange(new int[] {2, 2}, 2);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
