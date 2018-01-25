public class Question392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        int i = 0;
        int j = 0;
        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i += 1;
                if (i == s.length())
                    return true;
            }
            j += 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Question392IsSubsequence tmp = new Question392IsSubsequence();
        System.out.println(tmp.isSubsequence("axc", "ahbgdc"));
    }
}
