public class Question387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] counter =  new int[26];
        for (int i = 0; i < s.length(); i += 1) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i += 1) {
            if (counter[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
