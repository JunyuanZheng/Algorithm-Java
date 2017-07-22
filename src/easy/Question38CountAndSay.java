package easy;

public class Question38CountAndSay {
    public static String countAndSay(int n) {
        String result = "1";
        for (int i = 0; i < n - 1; i += 1) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = result.toCharArray();
            char value = chars[0];
            int counter = 1;
            for (int j = 1; j < chars.length; j += 1) {
                if (chars[j] == value) {
                    counter += 1;
                }
                else {
                    stringBuilder.append(counter);
                    stringBuilder.append(value);
                    value = chars[j];
                    counter = 1;
                }
            }
            stringBuilder.append(counter);
            stringBuilder.append(value);
            result = new String(stringBuilder);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
