using System;
using System.Collections.Generic;

class Question150E0valuateReversePolishNotation
{
    public int EvalRPN(string[] tokens)
    {
        string[] operators = new string[] { "+", "-", "*", "/" };
        Stack<string> tmp = new Stack<string>();
        foreach (string str in tokens)
        {
            if (Array.IndexOf(operators, str) != -1)
            {
                string val2 = tmp.Pop();
                string val1 = tmp.Pop();
                int result = 0;
                switch (str)
                {
                    case "+":
                        result = Int32.Parse(val1) + Int32.Parse(val2);
                        break;
                    case "-":
                        result = Int32.Parse(val1) - Int32.Parse(val2);
                        break;
                    case "*":
                        result = Int32.Parse(val1) * Int32.Parse(val2);
                        break;
                    case "/":
                        result = Int32.Parse(val1) / Int32.Parse(val2);
                        break;
                }
                tmp.Push(result.ToString());
            }
            else
            {
                tmp.Push(str);
            }
        }

        return Int32.Parse(tmp.Pop());
    }
}
