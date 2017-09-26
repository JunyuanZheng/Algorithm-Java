using System;

class Question134GasStation
{
    public int CanCompleteCircuit(int[] gas, int[] cost)
    {
        int start = gas.Length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];

        while (start > end)
        {
            if (sum >= 0)
            {
                sum += (gas[end] - cost[end]);
                end += 1;
            }
            else
            {
                start -= 1;
                sum += (gas[start] - cost[start]);
            }
        }

        return sum >= 0 ? start : -1;
    }
}