using System;

class Question167TwoSumII
{
    public int[] TwoSum(int[] numbers, int target)
    {
        int low = 0;
        int high = numbers.Length - 1;
        int[] result = new int[2];

        while (low < high)
        {
            int value = numbers[low] + numbers[high];
            if (value < target)
                low += 1;
            else if (value > target)
                high -= 1;
            else
            {
                result[0] = low + 1;
                result[1] = high + 1;
                break;
            }
        }

        return result;
    }
}
