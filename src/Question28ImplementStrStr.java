package easy;

public class Question28ImplementStrStr {
    /*
    My Method Exceed Limited Time
    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length())
            return -1;
        if (needle.equals(""))
            return 0;
        char[] chars = needle.toCharArray();
        for (int i = 0; i < haystack.toCharArray().length; i += 1) {
            for (int j = 0; j < chars.length; j += 1) {
                if (i + j < haystack.length() && haystack.charAt(i + j) == chars[j]) {
                    if (j == chars.length - 1) {
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }
    */

    // Really Elegant!
    public static int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issi"));
    }
}
