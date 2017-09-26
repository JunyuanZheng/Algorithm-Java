using System;

class Question171ExcelSheetColumnNumber
{
    public static int TitleToNumber(string s)
    {
        char[] chars = s.ToCharArray();
        int result = 0;
        foreach (char c in chars)
        {
            result = result * 26 + ((c - 'A') + 1);
        }
        return result;
    }
}

