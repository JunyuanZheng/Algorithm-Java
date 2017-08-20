using System;
using System.Collections.Generic;

public class Question77Combinations
{
	public IList<IList<int>> Combine(int n, int k)
	{
        IList<IList<int>> result = new List<IList<int>>();
        IList<int> temp = new List<int>();
        helper(result, temp, n, k, 1);
        return result;
	}

    private void helper(IList<IList<int>> result, IList<int> temp, int n, int k, int index)
    {
        if (k == 0)
        {
            result.Add(new List<int>(temp));
            Console.WriteLine(string.Join(",", temp));
            return;
        }

        for (int i = index; i <= n; i += 1)
        {
            temp.Add(i);
            helper(result, temp, n, k - 1, i + 1);
            temp.RemoveAt(temp.Count - 1);
        }
    }
}