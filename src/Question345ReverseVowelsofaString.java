import java.util.HashSet;
import java.util.Set;

public class Question345ReverseVowelsofaString {
    public String reverseVowels(String s) {
        if (s.length() == 0)
            return s;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] chars = s.toCharArray();
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            while (!set.contains(Character.toLowerCase(chars[low])) && low < high) {
                low += 1;
            }
            while (!set.contains(Character.toLowerCase(chars[high])) && low < high) {
                high -= 1;
            }
            char tmp = chars[low];
            chars[low] = chars[high];
            chars[high] = tmp;
            low += 1;
            high -= 1;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Question345ReverseVowelsofaString tmp = new Question345ReverseVowelsofaString();
        tmp.reverseVowels(",.");
    }
}
