package easy;

import java.util.*;

public class Question36ValidSudoku {
    /*
    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, List<Integer>> row = new HashMap<>();
        Map<Integer, List<Integer>> column = new HashMap<>();
        Map<Integer, List<Integer>> cell = new HashMap<>();
        // i row
        for (int i = 0; i < 9; i += 1) {
            // j column
            for (int j = 0; j < 9; j += 1) {
                if (board[i][j] != '.') {
                    int value = Character.getNumericValue(board[i][j]);
                    int index = (i / 3) * 3 + j / 3;

                    if (!row.containsKey(i)) {
                        row.put(i, new ArrayList<>());
                    }
                    if (!column.containsKey(j)) {
                        column.put(j, new ArrayList<>());
                    }
                    if (!cell.containsKey(index)) {
                        cell.put(index, new ArrayList<>());
                    }
                    if (row.get(i).contains(value))
                        return false;
                    else
                        row.get(i).add(value);

                    if (column.get(j).contains(value))
                        return false;
                    else
                        column.get(j).add(value);

                    if (cell.get(index).contains(value))
                        return false;
                    else
                        cell.get(index).add(value);
                }
            }
        }
        return true;
    }
    */
    // Much Better!!!!!!!
    public static boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'},
        };
        System.out.println(isValidSudoku(board));
    }
}
