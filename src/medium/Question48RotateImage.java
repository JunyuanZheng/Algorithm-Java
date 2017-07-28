package medium;

public class Question48RotateImage {
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i += 1) {
            for (int j = 0; j < matrix.length - 1 - i; j += 1) {
                helper(matrix, new int[] {i, j}, new int[] {matrix.length - 1 - j, matrix.length - 1 - i});
            }
        }

        for (int i = 0; i < matrix.length / 2; i += 1) {
            for (int j = 0; j < matrix.length; j += 1) {
                helper(matrix, new int[] {i, j}, new int[] {matrix.length - i - 1, j});
            }
        }
    }

    private static void helper(int[][] matrix, int[] i, int[] j) {
        int value = matrix[i[0]][i[1]];
        matrix[i[0]][i[1]] = matrix[j[0]][j[1]];
        matrix[j[0]][j[1]] = value;
    }

    public static void main(String[] args) {
        rotate(new int[][] {
                new int[] {1, 2, 3},
                new int[] {4, 5, 6},
                new int[] {7, 8, 9},
        });
    }
}
