using System;

public class Question80RemoveDuplicatesFromSortedArrayII
{
    public static int RemoveDuplicates(int[] nums)
    {
        int i = 0;
        foreach (int n in nums) {
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
        }
        return i;
    }
}