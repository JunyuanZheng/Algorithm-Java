public class Question258AddDigits {

    // https://discuss.leetcode.com/topic/28791/3-methods-for-python-with-explains
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
