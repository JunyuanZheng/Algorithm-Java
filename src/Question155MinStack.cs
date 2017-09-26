using System;
using System.Collections.Generic;

public class MinStack
{
    private Stack<int> minValueStack;
    private Stack<int> stack;

    public MinStack()
    {
        this.minValueStack = new Stack<int>();
        this.stack = new Stack<int>();
    }

    public void Push(int x)
    {
        int min = this.minValueStack.Count == 0 ? int.MaxValue : this.minValueStack.Peek();
        this.minValueStack.Push(Math.Min(x, min));
        stack.Push(x);
    }

    public void Pop()
    {
        this.minValueStack.Pop();
        this.stack.Pop();
    }

    public int Top()
    {
        return this.stack.Peek();
    }

    public int GetMin()
    {
        return this.minValueStack.Peek();
    }
}