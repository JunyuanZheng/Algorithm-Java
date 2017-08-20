using System;
using System.Collections.Generic;

public class Question78Subsets
{
	public IList<IList<int>> Subsets(int[] nums)
	{
        List<IList<int>> result = new List<IList<int>>();
        List<int> temp = new List<int>();
        for (int i = 0; i <= nums.Length; i += 1)
        {
            helper(nums, result, temp, i, 0, 0);
        }
        return result;
	}

    private void helper(int[] nums, List<IList<int>> result, List<int> temp, int size, int length, int index) {
        if (length == size)
        {
            result.Add(new List<int>(temp));
            return;
        }

        for (int i = index; i < nums.Length; i += 1)
        {
            temp.Add(nums[i]);
            helper(nums, result, temp, size, length + 1, i + 1);
            temp.RemoveAt(temp.Count - 1);
        }
    }
}