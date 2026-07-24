class Solution {

    public boolean isValidSudoku(char[][] board) {
        return areRowsValid(board)
                && areColumnsValid(board)
                && areSubBoxesValid(board);
    }

    private boolean areRowsValid(char[][] board) {
        for (int row = 0; row < 9; row++) {
            boolean[] seen = new boolean[9];

            for (int col = 0; col < 9; col++) {
                if (!markSeen(seen, board[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean areColumnsValid(char[][] board) {
        for (int col = 0; col < 9; col++) {
            boolean[] seen = new boolean[9];

            for (int row = 0; row < 9; row++) {
                if (!markSeen(seen, board[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean areSubBoxesValid(char[][] board) {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!isSubBoxValid(board, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSubBoxValid(char[][] board, int startRow, int startCol) {
        boolean[] seen = new boolean[9];

        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                if (!markSeen(seen, board[row][col])) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean markSeen(boolean[] seen, char c) {
        if (c == '.') {
            return true;
        }

        int index = c - '1';

        if (seen[index]) {
            return false;
        }

        seen[index] = true;
        return true;
    }
}