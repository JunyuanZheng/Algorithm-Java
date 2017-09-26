class Question189RotateArray
{
    public void Rotate(int[] nums, int k)
    {
        k %= nums.Length; // IMPORTANT!
        Helper(nums, 0, nums.Length - 1);
        Helper(nums, 0, k - 1);
        Helper(nums, k, nums.Length - 1);
    }

    private void Helper(int[] nums, int start, int end)
    {
        while (start < end)
        {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start += 1;
            end -= 1;
        }
    }
}
