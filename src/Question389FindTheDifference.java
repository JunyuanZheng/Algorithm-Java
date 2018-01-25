public class Question389FindTheDifference {
    public char findTheDifference(String s, String t) {
        int result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        return (char) result;
    }

    public static void main(String[] args) {
        Question389FindTheDifference tmp = new Question389FindTheDifference();
        System.out.println(tmp.findTheDifference("abcd", "abcde"));
    }
}
