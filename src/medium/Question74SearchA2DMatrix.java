package medium;

public class Question74SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0)
            return false;
        int column = matrix[0].length;
        if (column == 0)
            return false;

        int l = 0;
        int h = row * column - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (matrix[mid / column][mid % column] > target)
                h = mid - 1;
            else if (matrix[mid / column][mid % column] < target)
                l = mid + 1;
            else
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] {
                {1, 1}
        }, 2));
    }
}
