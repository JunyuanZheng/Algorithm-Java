import java.util.HashMap;
import java.util.Map;

public class Question383RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            int value = map.getOrDefault(c, 0);
            if (value == 0)
                return false;
            else
                map.put(c, map.get(c) - 1);
        }
        return true;
    }
}