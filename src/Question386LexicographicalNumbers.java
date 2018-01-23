import java.util.ArrayList;
import java.util.List;

public class Question386LexicographicalNumbers {
    // https://discuss.leetcode.com/topic/55184/java-o-n-time-o-1-space-iterative-solution-130ms
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Question386LexicographicalNumbers tmp = new Question386LexicographicalNumbers();
        System.out.println(tmp.lexicalOrder(100));
    }
}
