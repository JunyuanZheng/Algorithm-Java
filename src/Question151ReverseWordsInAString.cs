using System;
using System.Text.RegularExpressions;

class Question151ReverseWordsInAString
{
    public static string ReverseWords(string s)
    {
        string pattern = @"\s+";
        string[] result = Regex.Split(s.Trim(), pattern);
        string returnResult = "";
        for (int c = result.Length - 1; c > 0; c -= 1)
        {
            returnResult += result[c];
            returnResult += " ";
        }
        returnResult += result[0];
        return returnResult;
    }
}
