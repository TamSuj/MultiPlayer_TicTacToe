// Developer: Gayvalin Sujaritchai (CS 3B)
public class Main {
    public static void display(Board board) {
        System.out.println("Board: ");
        board.printBoard();
        System.out.println();
    }
    public static void main(String[] args) {

        int numPlayers = 0;
        int winnerStreak = 0;

//        Get input number of users to initialize Player object and Board class
        System.out.print("Enter the number of players (3-10): ");
        numPlayers = Helper.getUserInput();

        while (!GameLogic.validInput(3, 10, numPlayers)) {
            System.out.print("Re-enter the number of players (3-10): ");
            numPlayers = Helper.getUserInput();
        }

//        Get input number of winner streak
//        do{
//            System.out.print("Enter the number of winning piece (3-" + (numPlayers+1) + "): ");
//            winnerStreak = getUserInput();
//        }while (!GameLogic.validInput(3, numPlayers+1, winnerStreak));

        System.out.print("Enter the number of winning piece (3-" + (numPlayers+1) + "): ");
        winnerStreak = Helper.getUserInput();

        while (!GameLogic.validInput(3, numPlayers+1, winnerStreak)) {
            System.out.print("Re-enter the number of winning piece (3-" + (numPlayers+1) + "): ");
            winnerStreak = Helper.getUserInput();
        }

//        Initialize board according to the number of players
        Board board = new Board(numPlayers);

//        Initialize vector of players
        Player[] players = new Player[numPlayers];

//        Initialize players by giving each Player obj unique marker
        for (int i = 0; i < numPlayers; i++)
            players[i] = new Player(GameLogic.markers[i]);

//        Display the starting board
        display(board);

//        Start/continue the game as long as there's no winner and the board is not full
        while(!GameLogic.full(board) && !GameLogic.end(board, winnerStreak)) {
//            Iterate through each player
            for (int i = 0; i < numPlayers; i++) {
                System.out.println("Player " + (i + 1) + "'s turn (" + players[i].getMark() + ")");
                int row = 0, col = 0;

                do {
                    System.out.print("Enter the number of row: ");
                    row = Helper.getUserInput();
                    System.out.print("Enter the number of column: ");
                    col = Helper.getUserInput();
                    System.out.println();
                } while (!GameLogic.validInput(0, numPlayers, row-1) || !GameLogic.validInput(0, numPlayers, col-1)
                        ||!GameLogic.emptySpace(row - 1, col - 1, board));

                if (!GameLogic.full(board))
                    board.fillBoard(row - 1, col - 1, players[i].getMark());

                display(board);

                if(GameLogic.full(board) || GameLogic.end(board, winnerStreak))
                    break;
            }
        }

        System.out.println("Game over! Thanks for playing!");

    }

}