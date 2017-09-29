import java.util.HashMap;

public class Question205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i += 1) {
            char v1 = s.charAt(i);
            char v2 = t.charAt(i);
            if (hashMap.containsKey(v1)) {
                if (hashMap.get(v1).equals(v2))
                    continue;
                else
                    return false;
            } else {
                if (!hashMap.containsValue(v2))
                    hashMap.put(v1, v2);
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question205IsomorphicStrings tmp = new Question205IsomorphicStrings();
        tmp.isIsomorphic("ab", "aa");
    }
}
