class Solution {
     public boolean isValidSudoku(char[][] board) {
        return areRowsValid(board) && areColumnsValid(board) && areSubBoxesValid(board);
    }

    private boolean areSubBoxesValid(char[][] board) {
        for (int i = 0; i < board.length; i+=3) {
            for (int j = 0; j < board.length; j+=3) {
                if(!isSubBoxValid(board,i,j))
                    return false;
            }
        }
        return true;
    }


    private boolean isSubBoxValid(char[][] board, int i, int j) {
        Set<Character> dupCheckBag= new HashSet<>();
        for (int xi = i; xi < i+3 ; xi++) {
            for (int xj = j; xj < j+3; xj++) {
                char c = board[xi][xj];
                if (c != '.') {
                    if (isCharValidSym(c) && !dupCheckBag.add(c)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isCharValidSym(char c) {
        boolean value = (c > (int)'0' && c <= (int)'9') || c == '.';
        return value;
    }

    private boolean areColumnsValid(char[][] board) {
        for (int i = 0; i <board.length; i++) {
            Set<Character> dupCheckBag= new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (isCharValidSym(c) && !dupCheckBag.add(c)){
                        return false;
                    }
                }
            }

        }
        return true;
    }



    private boolean areRowsValid(char[][] board) {
        for (int i = 0; i <board.length; i++) {
            Set<Character> dupCheckBag= new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (isCharValidSym(c) && !dupCheckBag.add(c)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
