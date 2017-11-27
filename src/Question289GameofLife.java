public class Question289GameofLife {
    // Cleaner code: https://discuss.leetcode.com/topic/29054/easiest-java-solution-with-explanation
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;

        for (int i = 0; i < board.length; i += 1) {
            for (int j = 0; j < board[0].length; j += 1) {
                int lives = counter(board, i, j);

                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;  // Get the 2nd state.
            }
        }
    }

    private int counter(int[][] board, int i, int j) {
        int startCol = j - 1 >= 0 ? j - 1 : 0;
        int endCol = j + 1 <= board[0].length - 1 ? j + 1 : board[0].length - 1;
        int startRow = i - 1 >= 0 ? i - 1 : 0;
        int endRow = i + 1 <= board.length - 1 ? i + 1 : board.length - 1;
        int counter = 0;
        for (int row = startRow; row <= endRow; row += 1) {
            for (int col = startCol; col <= endCol; col += 1) {
                counter += board[row][col] & 1;
            }
        }
        counter -= board[i][j] & 1;
        return counter;
    }

    public static void main(String[] args) {
        Question289GameofLife tmp = new Question289GameofLife();
        tmp.gameOfLife(new int[][] {{1, 1}, {1, 0}});
    }
}
