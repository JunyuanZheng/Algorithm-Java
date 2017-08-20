package easy;

public class Question58LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if (strings.length == 0)
            return 0;
        return strings[strings.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
