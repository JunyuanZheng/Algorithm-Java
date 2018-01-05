public class Question367ValidPerfectSquare {
    // Method 1
    /*
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
    */

    // Method 2
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == num) {
                return true;
            } if (mid * mid < num) {
                low = (int)mid + 1;
            } else {
                high = (int)mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Question367ValidPerfectSquare tmp = new Question367ValidPerfectSquare();
        System.out.print(tmp.isPerfectSquare(2147483647));
    }
}
