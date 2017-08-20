package easy;

public class Question9PalindromeNumber {
    public static boolean isPalindrome(int x) {
        // !!! NEED TO CHECK CONDITION !!!
        if (x<0 || (x!=0 && x%10==0)) return false;
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return (x == reverse || x == reverse / 10);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
