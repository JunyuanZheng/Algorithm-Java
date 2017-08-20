package easy;

import java.util.ArrayList;
import java.util.List;

public class Question54SpiralMatrix {
    public enum DIRECTION {
        RIGHT,
        DOWN,
        LEFT,
        UP,
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix.length == 0)
            return results;
        int top = 0;
        int button = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        DIRECTION direction = DIRECTION.RIGHT;
        while (top <= button && left <= right) {
            switch (direction) {
                case RIGHT:
                    for (int i = left; i <= right; i += 1) {
                        results.add(matrix[top][i]);
                    }
                    top += 1;
                    direction = DIRECTION.DOWN;
                    break;
                case DOWN:
                    for (int i = top; i <= button; i += 1) {
                        results.add(matrix[i][right]);
                    }
                    right -= 1;
                    direction = DIRECTION.LEFT;
                    break;
                case LEFT:
                    for (int i = right; i >= left; i -= 1) {
                        results.add(matrix[button][i]);
                    }
                    button -= 1;
                    direction = DIRECTION.UP;
                    break;
                case UP:
                    for (int i = button; i >= top; i -= 1) {
                        results.add(matrix[i][left]);
                    }
                    left += 1;
                    direction = DIRECTION.RIGHT;
                    break;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][] {
                {2, 3},
        }));
    }
}
