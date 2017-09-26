using System;
using System.IO;
using System.Linq;
using System.Text;

class Question179LargestNumber
{
    public string LargestNumber(int[] nums)
    {
        string[] tmp = nums.Select(x => x.ToString()).ToArray();
        StringBuilder stringBuilder = new StringBuilder();
        Array.Sort(tmp, (string a, string b) => (b + a).CompareTo(a + b));
        if (tmp[0].Equals("0"))
            return "0";
        foreach (string s in tmp)
        {
            stringBuilder.Append(s);
        }
        return stringBuilder.ToString();
    }
}
