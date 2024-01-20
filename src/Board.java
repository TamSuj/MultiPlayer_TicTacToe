public class Board {
    String[][] board; //2D array storing the marker of each player

    /**
     * Constructor which initialize the board (2D Array) with size numPlayers+1 x numPlayers+1
     * @param numPlayers
     */
    public Board(int numPlayers){
        board = new String[numPlayers+1][numPlayers+1];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                board[i][j] = "_";
        }
    }

    /**
     * Fill the board at the passing row and column with the passing sign
     * @param row
     * @param col
     * @param sign
     */
    public void fillBoard(int row, int col, String sign){
        board[row][col] = sign;
    }

    /**
     * Print the board with labels and borders
     */
    public void printBoard(){
        for (int c = 0; c < board.length; c++)
            System.out.format("%4s", (c+1));
        System.out.println();
        System.out.format("%2s", " ");
        for (int j = 0; j < board.length; j++)
            System.out.print("----");
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            System.out.format("%2s", (i+1) + " ");

            for (int j = 0; j < board[i].length; j++) {
                if(j != 0)
                    System.out.format("%2s", "|");
                System.out.format("%2s", board[i][j]);
            }

            System.out.print("\n  ");
            for (int j = 0; j < board.length; j++)
                System.out.print("----");
            System.out.println();
        }
    }

    /**
     * Getter to return the board
     * @return board
     */
    public String[][] getBoard(){
        return board;
    }
}
