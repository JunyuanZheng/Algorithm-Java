package easy;

public class ReverseWordsInAStringIII {
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
        }
        reverse(chars, i, chars.length - 1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int low, int high) {
        while (low < high) {
            char chars1 = chars[low];
            chars[low] = chars[high];
            chars[high] = chars1;
            low += 1;
            high -= 1;
        }
    }

    public static void main(String[] args) {
        String result = reverseWords("Let's take LeetCode contest");
        System.out.println(result);
    }
}
