package medium;

public class Question6ZigZagConversion {
    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        /*
        int index = 1;
        boolean isDown = true;
        for (int i = 0; i < chars.length; i++) {
            stringBuilders[index - 1].append(chars[i]);
            if (isDown && index != numRows) {
                index += 1;
            }
            else if (!isDown) {
                index -= 1;
            }
            if (index == 1) {
                isDown = true;
            } else if (index == numRows) {
                isDown = false;
            }
        }
        */

        // A better way
        int i = 0;
        while (i < chars.length) {
            for (int index = 0; index < numRows && i < chars.length; index += 1) {
                stringBuilders[index].append(chars[i++]);
            }
            for (int index = numRows - 2; index >= 1 && i < chars.length; index -= 1) {
                stringBuilders[index].append(chars[i++]);
            }
        }

        String result = "";
        for (int counter = 0; counter < numRows; counter++) {
            result = result.concat(new String(stringBuilders[counter]));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
