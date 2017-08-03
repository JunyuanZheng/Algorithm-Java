package medium;

public class Question59SpiralMatrixII {
    private enum DIRECTION {
        RIGHT,
        DOWN,
        LEFT,
        UP,
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int button = n - 1;
        int index = 1;
        DIRECTION direction = DIRECTION.RIGHT;
        while (index <= Math.pow(n, 2)) {
            switch (direction) {
                case RIGHT:
                    for (int i = left; i <= right; i += 1) {
                        result[top][i] = index;
                        index += 1;
                    }
                    top += 1;
                    direction = DIRECTION.DOWN;
                    break;
                case DOWN:
                    for (int i = top; i <= button; i += 1) {
                        result[i][right] = index;
                        index += 1;
                    }
                    right -= 1;
                    direction = DIRECTION.LEFT;
                    break;
                case LEFT:
                    for (int i = right; i >= left; i -= 1) {
                        result[button][i] = index;
                        index += 1;
                    }
                    button -= 1;
                    direction = DIRECTION.UP;
                    break;
                case UP:
                    for (int i = button; i >= top; i -= 1) {
                        result[i][left] = index;
                        index += 1;
                    }
                    left += 1;
                    direction = DIRECTION.RIGHT;
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }
}
