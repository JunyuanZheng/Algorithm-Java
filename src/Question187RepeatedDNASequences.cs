using System;
using System.Collections.Generic;

class Question187RepeatedDNASequences
{
    /* Method 1
    public static IList<string> FindRepeatedDnaSequences(string s)
    {
        IList<string> result = new List<string>();
        ISet<int> singleSet = new HashSet<int>();
        ISet<int> doubleSet = new HashSet<int>();
        int[] map = new int[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for (int i = 0; i < s.Length - 9; i++)
        {
            int v = 0;
            for (int j = i; j < i + 10; j++)
            {
                v <<= 2;
                v |= map[s[j] - 'A'];
            }
            if (!singleSet.Add(v) && doubleSet.Add(v))
            {
                result.Add(s.Substring(i, 10));
            }
        }

        return result;
    }
    */

    // Method 2
    public static IList<string> FindRepeatedDnaSequences(string s)
    {
        ISet<string> set = new HashSet<string>();
        ISet<string> result = new HashSet<string>();
        for (int i = 0; i + 9 < s.Length; i += 1)
        {
            string tmp = s.Substring(i, 10);
            if (!set.Add(tmp))
            {
                result.Add(tmp);
            }
        }
        return new List<string>(result);
    }
}
