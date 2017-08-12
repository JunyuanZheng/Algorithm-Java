package easy;

public class Question66PlusOne {
    public static int[] plusOne(int[] digits) {
        int overflow =  (digits[digits.length - 1] + 1) > 9 ? 1 : 0;
        digits[digits.length - 1] = overflow == 0 ? digits[digits.length - 1] + 1 : 0;
        for (int i = digits.length - 2; i >= 0; i -= 1) {
            if (overflow == 0) {
                break;
            } else {
                digits[i] = digits[i] + overflow;
                overflow = (digits[i] > 9) ? 1 : 0;
                digits[i] = overflow == 0 ? digits[i] : 0;
            }
        }
        if (overflow == 0) {
            return digits;
        } else {
            int[] newArray = new int[digits.length + 1];
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            newArray[0] = overflow;
            return newArray;
        }
    }

    public static void main(String[] args) {
        for (int value: plusOne(new int[] {9})) {
            System.out.println(value);
        }
    }
}
