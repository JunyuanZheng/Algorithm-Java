import java.util.ArrayList;
import java.util.List;

public class Question131PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        helper(result, tmp, s, 0, s.length());
        return result;
    }

    private static void helper(List<List<String>> result, List<String> tmp, String s, int start, int end) {
        if (start == end) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start + 1; i <= end; i += 1) {
            String f = s.substring(start, i);
            String rf = new StringBuilder(f).reverse().toString();
            if (f.equals(rf)) {
                tmp.add(f);
                helper(result, tmp, s, i, end);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
