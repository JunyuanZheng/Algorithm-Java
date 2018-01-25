public class Question393UTF8Validation {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i += 1) {
            if (data[i] > 255)
                return false;
            int numberOfBytes = 0;
            if ((data[i] & 128) == 0) {
                numberOfBytes = 1;
            } else if ((data[i] & 224) == 192) {
                numberOfBytes = 2;
            } else if ((data[i] & 240) == 224) {
                numberOfBytes = 3;
            } else if ((data[i] & 248) == 240) {
                numberOfBytes = 4;
            } else {
                return false;
            }
            for (int j = 1; j < numberOfBytes; j++) {
                if (i + j >= data.length) return false;
                if ((data[i + j] & 192) != 128) return false; // 192(11000000), 128(10000000)
            }
            i = i + numberOfBytes - 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Question393UTF8Validation tmp = new Question393UTF8Validation();
        System.out.println(tmp.validUtf8(new int[]{248, 130, 130, 130}));
    }
}
