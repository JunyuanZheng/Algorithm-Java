package easy;

public class Question35SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return nums[l] >= target ? l : l + 1;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 0));
    }
}
