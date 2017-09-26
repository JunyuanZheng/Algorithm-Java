using System;

class Question165CompareVersionNumbers
{
    public static int CompareVersion(string version1, string version2)
    {
        string[] v1 = version1.Split('.');
        string[] v2 = version2.Split('.');
        for (int i = 0; i < Math.Max(v1.Length, v2.Length); i += 1)
        {
            int i1 = i < v1.Length ? int.Parse(v1[i]) : 0;
            int i2 = i < v2.Length ? int.Parse(v2[i]) : 0;
            if (i1 < i2)
                return -1;
            else if (i1 > i2)
                return 1;
        }
        return 0;
    }
}
