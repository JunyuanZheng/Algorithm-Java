public class Question287FindtheDuplicateNumber {
    // Super smart!
    // https://leetcode.com/problems/find-the-duplicate-number/description/
    public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
        return -1;
    }
}
