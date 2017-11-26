import java.util.Arrays;

public class Question274HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int index = 0;
        for (int i = citations.length - 1; i >= 0; i -= 1, index += 1) {
            if (index >= citations[i]) {
                return index;
            }
        }
        return index;
    }
    /*
    Clean code
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len=citations.length;
        for(int i=0;i<len;i++){
            if(citations[i]>=len-i) return len-i;

        }
        return 0;
    }
    */

    public static void main(String[] args) {
        Question274HIndex tmp = new Question274HIndex();
        System.out.println(tmp.hIndex(new int[] {1}));
    }
}
