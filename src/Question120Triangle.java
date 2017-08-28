import java.util.ArrayList;
import java.util.List;

public class Question120Triangle {
    /*
    public static int minimumTotal(List<List<Integer>> triangle) {
        int result = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i += 1) {
            List<Integer> tmp = triangle.get(i);
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < tmp.size(); j += 1) {
                int val;
                if (j == 0)
                    val = triangle.get(i - 1).get(0) + tmp.get(0);
                else if (j == tmp.size() - 1)
                    val = triangle.get(i - 1).get(j - 1) + tmp.get(j);
                else
                    val = Math.min(triangle.get(i - 1).get(j) + tmp.get(j), triangle.get(i - 1).get(j - 1) + tmp.get(j));
                tmp.set(j, val);
                min = Math.min(min, val);
            }
            result = min;
            triangle.set(i, tmp);
        }
        return result;
    }
    */
    // More Elegant!
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
        List<Integer> t1 = new ArrayList<>();
        t1.add(2);
        List<Integer> t2 = new ArrayList<>();
        t2.add(3);
        t2.add(4);
        List<Integer> t3 = new ArrayList<>();
        t3.add(6);
        t3.add(5);
        t3.add(7);
        List<Integer> t4 = new ArrayList<>();
        t4.add(4);
        t4.add(1);
        t4.add(8);
        t4.add(3);
        test.add(t1);
        test.add(t2);
        test.add(t3);
        test.add(t4);
        System.out.println(minimumTotal(test));
    }
}
