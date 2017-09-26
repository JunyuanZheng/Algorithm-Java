using System;

class Question152MaximumProductSubarray
{
    public static int MaxProduct(int[] nums)
    {
        int r = nums[0];

        for (int i = 1, imax = r, imin = r; i < nums.Length; i++)
        {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (nums[i] < 0)
            {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.Max(nums[i], imax * nums[i]);
            imin = Math.Min(nums[i], imin * nums[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.Max(r, imax);
        }

        return r;
    }
}
