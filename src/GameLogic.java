public class GameLogic {
    static String[] markers = {"X", "O", "*", "^", "%", "#", "@", "+", "/", "&", "$"};

    public static boolean diagonal(String[][] board, String mark, int winnerStreak) {
//        Implement here
        int size = board.length;

//        Every time we spot the mark in the board, we check if there's diagonal match
//        both in the left and right direction
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(board[row][col] == mark) {
                    int count = 0;

                    if(count >= winnerStreak) {
                        System.out.println("Diagonal match found");
                        return true;
                    }

                }

            }

        }

        return false;
    }

    public static boolean diagonal(Board board, String mark, int winnerStreak) {
        return diagonal(board.getBoard(), mark, winnerStreak);
    }

    public static boolean horizontal(String[][] board, String mark, int winnerStreak) {
//        Implement here
        int size = board.length;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
//                If the mark is found, we check if there's vertical match by checking the column of the same row
                if(board[row][col] == mark) {
                    int count = 0;

                    for (int i = 0; i < size; i++) {
                        if(board[row][i] == mark)
                            count++;
                    }
                    
                    if(count >= winnerStreak) {
                        System.out.println("Horizontal match of " + mark + " by Player " + playerNum(mark) + " is found");
                        return true;
                    }

                }

            }

        }

        return false;
    }

    public static boolean horizontal(Board board, String mark, int winnerStreak) {
        return horizontal(board.getBoard(), mark, winnerStreak);
    }

    public static boolean vertical(String[][] board, String mark, int winnerStreak) {
//        Implement here
        int size = board.length;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(board[row][col] == mark) {
                    int count = 0;

                    for (int i = 0; i < size; i++) {
                        if(board[i][col] == mark)
                            count++;
                    }

                    if(count >= winnerStreak) {
                        System.out.println("Vertical match of " + mark + " by Player " + playerNum(mark) + " is found");
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

    public static boolean full(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == "_")
                    return false;
            }
        }
        return true;
    }

    public static boolean full(Board board) {
        return full(board.getBoard());
    }

    public static boolean emptySpace(int row, int col, String[][] board) {
        return board[row][col] == "_";
    }

    public static boolean emptySpace(int row, int col, Board board) {
        return board.getBoard()[row][col] == "_";
    }

    public static boolean validInput(int lowerBound, int upperBound, int input) {
        return input >= lowerBound && input <= upperBound;
    }

    public static boolean end(Board board, int winningStreak){
        for (int i = 0; i < board.getBoard().length; i++) {
            String mark = markers[i];
            if(diagonal(board, mark, winningStreak) || horizontal(board, mark, winningStreak) || vertical(board, mark, winningStreak))
                return true;

        }
        return false;
    }

    public static int playerNum(String mark){
        for (int i = 0; i < markers.length; i++) {
            if(markers[i] == mark)
                return i+1;
        }
        return -1;
    }
}