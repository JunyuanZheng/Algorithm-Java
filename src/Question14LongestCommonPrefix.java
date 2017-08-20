package easy;

// 4 different methods
// http://www.geeksforgeeks.org/longest-common-prefix-set-3-divide-and-conquer/
// http://www.geeksforgeeks.org/longest-common-prefix-set-4-binary-search/

public class Question14LongestCommonPrefix {
    // Method 1: http://www.geeksforgeeks.org/longest-common-prefix-set-1-word-by-word-matching/
    /*
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i += 1) {
            // This is smart!
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (result.isEmpty()) return "";
            }
        }
        return result;
    }
    */

    // Method 2: http://www.geeksforgeeks.org/longest-common-prefix-set-2-character-by-character-matching/
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        for (int i = 0; i < strs[0].length(); i += 1) {
            char data = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j += 1) {
                if (i == strs[j].length() || strs[j].charAt(i) != data)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"aa", "a"}));
    }
}
