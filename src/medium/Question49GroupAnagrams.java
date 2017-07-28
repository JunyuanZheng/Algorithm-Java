package medium;

import java.util.*;

public class Question49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String string : strs) {
            char[] c = string.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if (!result.containsKey(sorted))
                result.put(sorted, new ArrayList<>());
            result.get(sorted).add(string);
        }
        return new ArrayList<>(result.values());
    }
}
