/**
 * GameLogic class that contains all the game logic (check vertical/horizontal/diagonal match, check if the board is full, etc.)
 */
public class GameLogic {
    final static String[] markers = {"X", "O", "*", "^", "%", "#", "@", "+", "/", "&"}; // Array of markers for each player

    /**
     * Check if there's a diagonal match of the passing mark in the board
     * @param board
     * @param mark
     * @param winnerStreak
     * @return true if there's a diagonal match, else false
     */
    public static boolean diagonal(String[][] board, String mark, int winnerStreak) {
//        Implement here
        int size = board.length;

//        Every time we spot the mark in the board, we check if there's diagonal match in left and right direction
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // If the mark is found, check diagonal match
                if(board[row][col].equals(mark)) {

                    // Diagonal match in right direction
                    int count = 0;

                    for (int i = 0; i < size-col; i++) {
                        if(validInput(0, size-1,row+i) && validInput(0, size-1,col+i)
                                && board[row+i][col+i].equals(mark))
                            count++;
                        else
                            break;
                    }

                    if(count >= winnerStreak) {
//                        System.out.println("Diagonal match found");
                        return true;
                    }

                    // Diagonal match in left direction
                    count = 0;

                    for (int i = 0; i <= col; i++) {
                        if(validInput(0, size-1,row+i) && validInput(0, size-1,col-i)
                                && board[row+i][col-i].equals(mark))
                            count++;
                        else
                            break;
                    }

                    if(count >= winnerStreak) {
//                        System.out.println("Diagonal match found");
                        return true;
                    }
                }

            }

        }

        return false; // Return false by default
    }

    /**
     * Overloaded method of diagonal that takes Board object as parameter (usability)
     * @param board
     * @param mark
     * @param winnerStreak
     * @return true if there's a diagonal match, else false
     */
    public static boolean diagonal(Board board, String mark, int winnerStreak) {
        return diagonal(board.getBoard(), mark, winnerStreak);
    }

    /**
     * Check if there's a horizontal match of the passing mark in the board
     * @param board
     * @param mark
     * @param winnerStreak
     * @return true if there's a horizontal match, else false
     */
    public static boolean horizontal(String[][] board, String mark, int winnerStreak) {
        int size = board.length;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
//                If the mark is found, we check if there's vertical match by checking the column of the same row
                if(board[row][col].equals(mark)) {
                    int count = 0;

                    for (int i = col; i < size; i++) {
                        if(board[row][i].equals(mark))
                            count++;
                        else
                            break;
                    }
                    
                    if(count >= winnerStreak) {
//                        System.out.println("Horizontal match found");
                        return true;
                    }


                }

            }

        }

        return false; // Return false by default
    }

    /**
     * Overloaded method of horizontal that takes Board object as parameter (usability)
     * @param board
     * @param mark
     * @param winnerStreak
     * @return true if there's a horizontal match, else false
     */
    public static boolean horizontal(Board board, String mark, int winnerStreak) {
        return horizontal(board.getBoard(), mark, winnerStreak);
    }

    /**
     * Check if there's a vertical match of the passing mark in the board
     * @param board
     * @param mark
     * @param winnerStreak
     * @return true if there's a vertical match, else false
     */
    public static boolean vertical(String[][] board, String mark, int winnerStreak) {
//        Implement here
        int size = board.length;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(board[row][col].equals(mark)) {
                    int count = 0;

                    for (int i = 0; i < size; i++) {
                        if(board[i][col].equals(mark))
                            count++;
                        else
                            break;
                    }

                    if(count >= winnerStreak) {
//                        System.out.println("Vertical match found");
                        return true;
                    }

                }

            }

        }

        return false;
    }

    public static boolean vertical(Board board, String mark, int winnerStreak) {
        return vertical(board.getBoard(), mark, winnerStreak);
    }

    /**
     * Check if the board is full by checking if there's any "_" in the board
     * @param board
     * @return true if the board is full, else false
     */
    public static boolean full(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("_"))
                    return false;
            }
        }
        return true;
    }

    /**
     * Overloaded method of full that takes Board object as parameter (usability)
     * @param board
     * @return true if the board is full, else false
     */
    public static boolean full(Board board) {
        return full(board.getBoard());
    }

    /**
     * Check if the spot is empty by checking if the spot is "_"
     * @param row
     * @param col
     * @param board
     * @return true if the spot is empty, else false
     */
    public static boolean emptySpace(int row, int col, String[][] board) {
        return board[row][col].equals("_");
    }

    /**
     * Overloaded method of emptySpace that takes Board object as parameter (usability)
     * @param row
     * @param col
     * @param board
     * @return true if the spot is empty, else false
     */
    public static boolean emptySpace(int row, int col, Board board) {
        return board.getBoard()[row][col].equals("_");
    }

    /**
     * Check if the input is within the range of lowerBound and upperBound
     * @param lowerBound
     * @param upperBound
     * @param input
     * @return true if the input is within the range, else false
     */
    public static boolean validInput(int lowerBound, int upperBound, int input) {
        return input >= lowerBound && input <= upperBound;
    }

    /**
     * Check if there's a winner by checking if there's a diagonal, horizontal, or vertical match of all the mark.
     * If there's a match, return true, else false
     * @param board
     * @param winningStreak
     * @return true if there's a match, else false
     */
    public static boolean end(Board board, int winningStreak) {
        for (int i = 0; i < board.getBoard().length-1; i++) {
            String mark = markers[i];
            if(diagonal(board, mark, winningStreak) || horizontal(board, mark, winningStreak) || vertical(board, mark, winningStreak))
                return true;

        }
        return false; //return false by default
    }

    /**
     * Return the player number by passing the mark (index+1 since index starts at 0 but player number starts at 1)
     * @param mark
     * @return player number (index+1)
     */
    public static int playerNum(String mark){
        for (int i = 0; i < markers.length; i++) {
            if(markers[i].equals(mark))
                return i+1;
        }
        return -1; // Return -1 by default (if the mark is not found)
    }
}