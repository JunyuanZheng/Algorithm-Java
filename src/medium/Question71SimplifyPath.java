package medium;

import java.util.Deque;
import java.util.LinkedList;

public class Question71SimplifyPath {
    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> stringStack = new LinkedList<>();
        for (String s : paths) {
            if (!s.equals("")) {
                switch (s) {
                    case "..":
                        if (!stringStack.isEmpty())
                            stringStack.pop();
                        break;
                    case ".":
                        break;
                    default:
                        stringStack.push(s);
                        break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stringStack.isEmpty()) {
            stringBuilder.append("/").append(stringStack.pollLast());
        }
        return stringBuilder.length() != 0 ? new String(stringBuilder) : "/";
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/abc/..."));
    }
}
