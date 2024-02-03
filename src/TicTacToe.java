// Developed by Gayvalin Sujaritchai (CS 3B)
public class TicTacToe {
    public static void main(String[] args) {
        do{
            int numPlayers = 0, winnerStreak = 0;

//        Get input number of users to initialize Player object and Board class and validate input
            numPlayers = Helper.promptUserInput("Enter the number of players (3-10): ", 3, 10);

//        Get input number of pieces need to win the game and validate input
            winnerStreak = Helper.promptUserInput("Enter the number of winning pieces (3-" + (numPlayers + 1) + "): ", 3, numPlayers + 1);

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
            while (!GameLogic.full(board) && !GameLogic.end(board, winnerStreak)) {
//            Iterate through each player
                for (int i = 0; i < numPlayers; i++) {
                    String mark = players[i].getMark();
                    int row = 0, col = 0;

                    System.out.println("Player " + (i + 1) + "'s turn (" + mark + ")");

//                Prompt user to input desire row and column, if the spot is taken, ask user for new spot with board display
                    row = Helper.promptBoardInput("Enter the number of row: ", 1, numPlayers + 1, board);
                    col = Helper.promptBoardInput("Enter the number of column: ", 1, numPlayers + 1, board);

                    while (!GameLogic.emptySpace(row - 1, col - 1, board)) {
                        System.out.println("The spot is taken/invalid");
                        row = Helper.promptBoardInput("Enter the number of row: ", 1, numPlayers + 1, board);
                        col = Helper.promptBoardInput("Enter the number of column: ", 1, numPlayers + 1, board);
                    }

//                If the board is not already full, fill in the spot with the player's mark
                    if (!GameLogic.full(board))
                        board.fillBoard(row - 1, col - 1, mark);

//                Display the board after the player made the move
                    Helper.display(board);

//                If the board is full or there's a winner, terminate the game
                    if (GameLogic.end(board, winnerStreak)) {
                        System.out.println("Player " + GameLogic.playerNum(mark) + " (" + mark + ") won. Congratulations!✨");
                        Helper.display(board);
                        break;
                    } else if (GameLogic.full(board)) {
                        System.out.println("The board is full and there's no winner (tie)");
                        Helper.display(board);
                        break;
                    }
                }
            }
            System.out.println("Game over! Thanks for playing!");
        }while(Helper.continueGame());
    }
}