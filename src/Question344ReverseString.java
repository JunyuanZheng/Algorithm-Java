public class Question344ReverseString {
    public String reverseString(String s) {
        if (s.length() == 0)
            return s;
        int low = 0;
        int high = s.length() - 1;
        char[] chars = s.toCharArray();
        while (low < high) {
            char tmp = chars[low];
            chars[low] = chars[high];
            chars[high] = tmp;
            low += 1;
            high -= 1;
        }
        return String.valueOf(chars);
    }
}
