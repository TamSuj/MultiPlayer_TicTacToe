import java.util.Scanner;

/**
 * Helper class contains helper methods for the game
 */
public class Helper {
    /**
     * Prompt user to input a number and return the number. Re-prompt user if the input is invalid (not an integer)
     * @return number (int)
     */
    public static int getUserInput() {
        Scanner input = new Scanner(System.in);
        int output = 0;

//        Try getting integer input and prompt user to re-enter if other data type is detected
        try {
            output = input.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input, re-enter:");
            return getUserInput(); // Recursive
        }
        return output;
    }

    /**
     * Display the board with labels:
     * @param board (Board)
     */
    public static void display(Board board) {
        System.out.println("Board: ");
        board.printBoard();
        System.out.println();
    }

    /**
     * Prompt user to input a number and validate the input if it's within the range. Re-prompt if the input is invalid by recursive call
     * @param message
     * @param lowerBound
     * @param upperBound
     * @return number (int)
     */
    public static int promptUserInput(String message, int lowerBound, int upperBound) {
        int result = 0;

        System.out.print(message);
        result = getUserInput();

        // Validate input. Re-prompt user if the input is invalid (ex: not within the range, not an integer)
        while (!GameLogic.validInput(lowerBound, upperBound, result)) {
            System.out.print("Re-" + message);
            result = getUserInput();
        }

        return result;
    }

    /**
     * Prompt user to input row and column and validate the input. Re-prompt user if the input is invalid (spot is taken)
     * @param message
     * @param lowerBound
     * @param upperBound
     * @param board
     * @return row or column (int)
     */
    public static int promptBoardInput(String message, int lowerBound, int upperBound, Board board){
        int result = 0;

        System.out.print(message);
        result = getUserInput();

        // Validate input. Re-prompt user if the input is invalid (ex: not within the range, not an integer)
        while(!GameLogic.validInput(lowerBound, upperBound, result)) {
            board.printBoard();
            System.out.println("The spot is taken/invalid.");
            return promptBoardInput(message, lowerBound, upperBound, board);
        }

        return result;
    }

    /**
     * Prompt user to input if they want to start a new game or not (y/n). Return true if yes, else false
     * @return true if restart game, else false (boolean)
     */
    public static boolean continueGame() {
        System.out.print("Start a new game? (y/n): ");
        Scanner input = new Scanner(System.in);
        String answer = "";

//        Try getting String input and prompt user to re-enter if other data type is detected
        try {
            answer = input.next();
        } catch (Exception e) {
            System.out.println("Invalid input, re-enter:");
            return continueGame(); // Recursive
        }

        if (answer.toLowerCase().equals("y")) {
            return true;
        } else if (answer.toLowerCase().equals("n")) {
            return false;
        } else {
            System.out.println("Invalid input, re-enter:");
            return continueGame(); // Recursive
        }
    }
}
