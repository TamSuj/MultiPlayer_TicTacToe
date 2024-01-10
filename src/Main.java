// Developer: Gayvalin Sujaritchai (CS 3B)
public class Main {
    public static void main(String[] args) {
        int numPlayers = 0, winnerStreak = 0;

//        Get input number of users to initialize Player object and Board class and validate input
        numPlayers = Helper.promptUserInput("Enter the number of players (3-10): ", 3, 10);

//        Get input number of pieces need to win the game and validate input
        winnerStreak = Helper.promptUserInput("Enter the number of winning piece (3-" + (numPlayers+1) + "): ", 3, numPlayers+1);

//        Initialize board according to the number of players
        Board board = new Board(numPlayers);

//        Initialize vector of players
        Player[] players = new Player[numPlayers];

//        Initialize players by giving each Player obj unique marker
        for (int i = 0; i < numPlayers; i++)
            players[i] = new Player(GameLogic.markers[i]);

//        Display the starting board
        Helper.display(board);

//        Start/continue the game as long as there's no winner and the board is not full
        while(!GameLogic.full(board) && !GameLogic.end(board, winnerStreak)) {
//            Iterate through each player
            for (int i = 0; i < numPlayers; i++) {
                System.out.println("Player " + (i + 1) + "'s turn (" + players[i].getMark() + ")");
                int row = 0, col = 0;

//                Prompt user to input desire row and column, if the spot is taken, ask user for new spot
                do {
                    row = Helper.promptUserInput("Enter the number of row: ", 1, numPlayers+1);
                    col = Helper.promptUserInput("Enter the number of column: ", 1, numPlayers+1);
                } while (!GameLogic.emptySpace(row - 1, col - 1, board));

//                If the board is not already full, fill in the spot with the player's mark
                if (!GameLogic.full(board))
                    board.fillBoard(row - 1, col - 1, players[i].getMark());

//                Display the board after the player made the move
                Helper.display(board);

//                If the board is full or there's a winner, terminate the game
                if(GameLogic.full(board) || GameLogic.end(board, winnerStreak))
                    break;
            }
        }
        System.out.println("Game over! Thanks for playing!");
    }
}