public class Question240Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col -= 1;
            else
                row += 1;
        }
        return false;
    }
}
