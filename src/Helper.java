import java.util.Scanner;

public class Helper {
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

    public static void display(Board board) {
        System.out.println("Board: ");
        board.printBoard();
        System.out.println();
    }

    public static int promptUserInput(String message, int lowerBound, int upperBound){
        int result = 0;

        System.out.print(message);
        result = getUserInput();

        while (!GameLogic.validInput(lowerBound, upperBound, result)) {
            System.out.print("Re-" + message);
            result = getUserInput();
        }
        return result;
    }

    public static int promptBoardInput(String message, int lowerBound, int upperBound, Board board){
        int result = 0;

        System.out.print(message);
        result = getUserInput();

        while (!GameLogic.validInput(lowerBound, upperBound, result)) {
            board.printBoard();
            System.out.print("Re-" + message);
            result = getUserInput();
        }
        return result;
    }
}
