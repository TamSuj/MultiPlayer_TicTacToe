public class Board {
    String[][] board; //2D array storing the marker of each player
    public Board(int numPlayers){
//        Initialize board (2D array) with size numPlayers+1 x numPlayers+1
        board = new String[numPlayers+1][numPlayers+1];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                board[i][j] = "_";
        }
    }

    public void fillBoard(int row, int col, String sign){
        board[row][col] = sign;
    }

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
    public String[][] getBoard(){
        return board;
    }
}
