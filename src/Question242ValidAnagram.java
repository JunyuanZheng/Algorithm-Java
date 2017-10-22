public class Question242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] tmp = new int[26];
        for (char c : s.toCharArray()) {
            tmp[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            tmp[c - 'a'] -= 1;
        }
        for (int i : tmp) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
