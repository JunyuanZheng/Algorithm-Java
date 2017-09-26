public class Question201BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int counter = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            counter += 1;
        }
        return m << counter;
    }
}
