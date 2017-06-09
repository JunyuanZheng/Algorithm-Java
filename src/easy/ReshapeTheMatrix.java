package easy;

import java.util.Arrays;

public class ReshapeTheMatrix {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;

        if (row * col == r * c) {
            int[] temp = new int[r * c];
            int k = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    temp[k] = nums[i][j];
                    k += 1;
                }
            }
            int index = 0;
            int[][] finalResult = new int[r][c];
            for (int i = 0; i < r; i++) {
                finalResult[i] = Arrays.copyOfRange(temp, index, index + c);
                index += c;
            }
            return finalResult;
        } else {
            return nums;
        }
    }

    /* Better One
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m) return nums;
        int[][] res = new int[r][c];
        for (int i=0;i<r*c;i++)
            res[i/c][i%c] = nums[i/m][i%m];
        return res;
    }
    */

    public static void main(String[] args) {
        int[][] data = new int[][] {
            {1, 2},
            {3, 4}
        };
        int[][] result = matrixReshape(data, 1, 4);
    }
}
