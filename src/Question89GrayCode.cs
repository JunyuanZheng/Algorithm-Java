using System.Collections.Generic;
using System;

public class Question89GrayCode
{
	public IList<int> GrayCode(int n)
	{
        IList<int> result = new List<int>();
        result.Add(0);
        for (int i = 1; i <= n; i += 1)
        {
            for (int j = result.Count - 1; j >= 0; j -=1)
			{
                result.Add(result[j] + (int)Math.Pow(2, i - 1));
			}
        }
        return result;
	}
}
