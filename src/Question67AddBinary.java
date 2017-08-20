package easy;

public class Question67AddBinary {
    /*
    public static String addBinary(String a, String b) {
        char[] inputA = a.toCharArray();
        char[] inputB = b.toCharArray();

        int minSize = inputA.length > inputB.length ? inputB.length : inputA.length;
        char[] baseChar = inputA.length > inputB.length ? inputA : inputB;
        int maxSize = inputA.length > inputB.length ? inputA.length : inputB.length;

        int overflow = 0;
        for (int i = 0; i < minSize; i += 1) {
            int newValue = Character.getNumericValue(inputA[inputA.length - 1 - i]) + Character.getNumericValue(inputB[inputB.length - 1 - i]) + overflow;
            overflow = newValue > 1 ? 1 : 0;
            baseChar[baseChar.length - 1 - i] = overflow == 0 ? Character.forDigit(newValue, 10) : Character.forDigit(newValue - 2, 10);
        }
        if (overflow == 0) {
            return new String(baseChar);
        } else {
            for (int i = minSize; i < maxSize; i += 1) {
                if (overflow == 0)
                    break;
                int newValue = Character.getNumericValue(baseChar[baseChar.length - 1 - i]) + overflow;
                overflow = newValue > 1 ? 1 : 0;
                baseChar[baseChar.length - 1 - i] = overflow == 0 ? Character.forDigit(newValue, 10) : Character.forDigit(newValue - 2, 10);
            }
        }

        if (overflow == 0) {
            return new String(baseChar);
        } else {
            char[] newArray = new char[baseChar.length + 1];
            System.arraycopy(baseChar, 0, newArray, 1, baseChar.length);
            newArray[0] = Character.forDigit(overflow, 10);
            return new String(newArray);
        }
    }
    */
    /*
    More Concise One !!!!!!!!!
     */
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1111", "1111"));
    }
}
