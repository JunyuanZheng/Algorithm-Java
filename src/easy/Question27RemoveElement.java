package easy;

public class Question27RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index += 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[] {3, 2, 2, 3}, 3));
    }
}
