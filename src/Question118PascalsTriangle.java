import java.util.ArrayList;
import java.util.List;

public class Question118PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i += 1) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 1; j <= i; j += 1) {
                if (j == 1 || j == i) {
                    tmp.add(1);
                } else {
                    List<Integer> l = result.get(i - 1 - 1);
                    tmp.add(l.get(j - 1 - 1) + l.get(j - 1));
                }
            }
            result.add(tmp);
        }
        return result;
    }
}
