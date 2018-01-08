public class Question374GuessNumberHigherOrLower {
    public int guess(int input) {
        if (input == 6)
            return 0;
        if (input < 2)
            return -1;
        return 1;
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int result = guess(mid);
            if (result == 0)
                return mid;
            else if (result == 1)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        Question374GuessNumberHigherOrLower tmp = new Question374GuessNumberHigherOrLower();
        tmp.guessNumber(10);
    }
}
