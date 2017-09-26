class Question191NumberOfOneBits
{
    public int HammingWeight(uint n)
    {
        int result = 0;
        for (int i = 0; i < 32; i += 1)
        {
            result += (n & 1) == 1 ? 1 : 0;
            n >>= 1;
        }
        return result;
    }
}
