import java.util.HashMap;
import java.util.Map;

public class Question388LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        String[] tmp = input.split("\n");
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (String s : tmp) {
            int level = s.lastIndexOf("\t") + 1;
            int length = map.getOrDefault(level, 0) + s.length() - level + 1;
            map.put(level + 1, length);
            if (s.contains(".")) {
                max = Math.max(max, length - 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Question388LongestAbsoluteFilePath tmp = new Question388LongestAbsoluteFilePath();
        System.out.println(tmp.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}
