using System;
using System.Text;

class Question168ExcelSheetColumnTitle
{
    public static string ConvertToTitle(int n)
    {
        return n == 0 ? "" : ConvertToTitle(--n / 26) + (char)('A' + n % 26);
    }
}
