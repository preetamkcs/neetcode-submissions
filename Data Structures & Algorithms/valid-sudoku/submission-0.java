class Solution {
     public boolean isValidSudoku(char[][] board) {
        return areRowsValid(board) && areColumnsValid(board) && areSubBoxesValid(board);
    }

    private boolean areSubBoxesValid(char[][] board) {
        for (int i = 0; i < board.length; i+=3) {
            for (int j = 0; j < board.length; j+=3) {
                System.out.printf("Checking subbox %s",printSubBox(board,i,j));
                if(!isSubBoxValid(board,i,j))
                    return false;
            }
        }
        return true;
    }

    private String printSubBox(char[][] board, int i, int j) {
        StringBuilder sb=new StringBuilder();
        sb.append('\n');
        for (int row = i; row < i+3; row++) {
            for (int col = j; col < j+3; col++) {
               sb.append(String.format("'%c' ",board[row][col]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private boolean isSubBoxValid(char[][] board, int i, int j) {
        System.out.printf("i=%d and j=%d\n",i,j);
        Set<Character> dupCheckBag= new HashSet<>();
        for (int xi = i; xi < i+3 ; xi++) {
            for (int xj = j; xj < j+3; xj++) {
                char c = board[xi][xj];
                if (c != '.') {
                    System.out.printf("checking %c in i=%d and j=%d\n", c,i,j);
                    if (isCharValidSym(c) && !dupCheckBag.add(c)){
                        return false;
                    }
                }
            }
        }
        System.out.println("Sub box OK!");
        return true;
    }

    private boolean isCharValidSym(char c) {
        boolean value = (c > (int)'0' && c <= (int)'9') || c == '.';
//        System.out.printf("Eval %c : %b\n",c,value);
        return value;
    }

    private boolean areColumnsValid(char[][] board) {
        for (int i = 0; i <board.length; i++) {
            Set<Character> dupCheckBag= new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (isCharValidSym(c) && !dupCheckBag.add(c)){
//                        System.out.printf("checking %c in i=%d and j=%d \n", c,i,j);
                        return false;
                    }
                }
            }
//            System.out.printf("Column OK: \n%s\n",printColum(board,i));

        }
//        System.out.println("ALL COLUMNS OK");
        return true;
    }

    private Object printColum(char[][] board, int i) {
        StringBuilder s = new StringBuilder();
        for (int row = 0; row < board.length; row++) {
           s.append("'").append(board[row][i]).append("'");
           if (row!=board.length-1){
               s.append("\n");
           }
        }
        return s;
    }

    private boolean areRowsValid(char[][] board) {
        for (int i = 0; i <board.length; i++) {
            Set<Character> dupCheckBag= new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (isCharValidSym(c) && !dupCheckBag.add(c)){
//                        System.out.printf("checking %c in i=%d and j=%d\n", c,i,j);
                        return false;
                    }
                }
            }
//            System.out.printf("row ok:%s \n",Arrays.toString(board[i]));
        }
//        System.out.println("ALL ROWS OK");
        return true;
    }
}
