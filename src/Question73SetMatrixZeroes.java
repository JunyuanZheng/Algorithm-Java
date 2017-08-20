package medium;

import java.util.HashSet;
import java.util.Set;

public class Question73SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        // Row
        Set<Integer> integerSet1 = new HashSet<>();

        // Column
        Set<Integer> integerSet2 = new HashSet<>();

        int row = matrix.length;
        int column = matrix[0].length;

        for (int i = 0; i < row; i += 1) {
            for (int j = 0; j < column; j += 1) {
                if (matrix[i][j] == 0) {
                    integerSet1.add(i);
                    integerSet2.add(j);
                }
            }
        }

        for (int i : integerSet1) {
            for (int j = 0; j < column; j += 1)
                matrix[i][j] = 0;
        }

        for (int i : integerSet2) {
            for (int j = 0; j < row; j += 1)
                matrix[j][i] = 0;
        }

    }
}
