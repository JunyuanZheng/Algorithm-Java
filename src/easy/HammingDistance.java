package easy;

public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int result = (x ^ y);
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            if ((result & 1) == 1)
                counter += 1;
            result >>= 1;
        }
        return counter;
    }
    public static void main(String[] args) {
        int result = hammingDistance(1, 4);
        System.out.println(result);
    }
}
