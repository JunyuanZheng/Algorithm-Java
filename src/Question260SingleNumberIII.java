public class Question260SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int tmp = 0;

        for (int i : nums) {
            tmp ^= i;
        }

        // Get its last set bit
        // 0xFFFFFFFF = -1
        // 0xFFFFFFFE = -2
        tmp &= -tmp;

        // Pass 2 :
        int[] result = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & tmp) == 0) // the bit is not set
            {
                result[0] ^= num;
            }
            else // the bit is set
            {
                result[1] ^= num;
            }
        }
        return result;
    }
}
