public class Question125ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String tmp = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return tmp.equals(new StringBuilder(tmp).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
