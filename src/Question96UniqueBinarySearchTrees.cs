using System;

public class Question96UniqueBinarySearchTrees
{
    public static int NumTrees(int n)
    {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        
        for (int i = 2; i <= n; i += 1)
        {
            for (int j = 0; j < i; j += 1)
            {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        Console.WriteLine(dp[n]);
        return dp[n];
    }
}