import java.util.Stack;

public class Question402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        //corner case
        if (k == len)
            return "0";

        Stack<Integer> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            int tmp = Character.getNumericValue(c);
            while (!stack.empty() && stack.peek() > tmp && k > 0) {
                stack.pop();
                k -= 1;
            }
            stack.push(tmp);
        }

        // corner case like "1111"
        while (k > 0) {
            stack.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();

        //remove all the 0 at the head
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
