using System;

class Question198HouseRobber
{
    public int Rob(int[] nums)
    {
        int prevNo = 0;
        int prevYes = 0;
        foreach (int value in nums)
        {
            int tmp = prevNo;
            prevNo = Math.Max(prevYes, prevNo);
            prevYes = tmp + value;
        }
        return Math.Max(prevNo, prevYes);
    }
}
