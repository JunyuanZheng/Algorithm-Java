using System;

class Question162FindPeakElement
{
    public int FindPeakElement(int[] nums)
    {
        int low = 0;
        int high = nums.Length - 1;

        while (low < high)
        {
            int mid1 = low + (high - low) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2])
                low = mid2;
            else
                high = mid1;
        }

        return low;
    }
}
