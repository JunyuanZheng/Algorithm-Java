import java.util.Random;

public class Question398RandomPickIndex {
    private int[] nums;
    private Random random;

    public Question398RandomPickIndex (int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int counter = 0;
        for (int i = 0; i < this.nums.length; i += 1) {
            if (this.nums[i] == target) {
                if (counter == 0) {
                    result = i;
                } else {
                    if (random.nextInt(counter + 1) == counter) {
                        result = i;
                    }
                }
                counter += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Question398RandomPickIndex test = new Question398RandomPickIndex(new int[] { 1, 2, 3, 3, 3 });
        System.out.println(test.pick(3));
        System.out.println(test.pick(3));
        System.out.println(test.pick(3));
        System.out.println(test.pick(3));
        System.out.println(test.pick(3));
        System.out.println(test.pick(3));
    }
}
