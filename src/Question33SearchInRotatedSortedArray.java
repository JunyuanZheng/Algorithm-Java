package medium;

public class Question33SearchInRotatedSortedArray {
    // KEY: The idea is that when rotating the array, there must be one half of the array that is still in sorted order.
    public static int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid])
                    h = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[h])
                    l = mid + 1;
                else
                    h = mid - 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {4, 6, 7, 8, 9, 1, 2}, 2));
    }
}
