import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question119PascalsTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i += 1) {
            result.add(0, 1);
            for (int j = 1; j < result.size() - 1; j += 1) {
                result.set(j, result.get(j) + result.get(j + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
