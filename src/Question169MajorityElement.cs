using System;

class Question169MajorityElement
{
    public static int MajorityElement(int[] nums)
    {
        Array.Sort(nums, (int a, int b) => a - b);
        return nums[(nums.Length - 1) / 2];
    }
}
