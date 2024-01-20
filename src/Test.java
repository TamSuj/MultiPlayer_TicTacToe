public class Test {
    public static void main(String[] args) {
        System.out.println("Testing...");
        testBoardClass();
        testGameLogicClass();
        testHelperClass();
        System.out.println("All tests passed!");
    }

    /**
     * Test Board class
     */
    public static void testBoardClass() {
        System.out.println("Testing Board class...");

        // Test Board initialization
        Board board = new Board(3);
        assert board.getBoard().length == 4 : "Board size is not 4x4";
        for (int i = 0; i < 4; i++)
            assert board.getBoard()[i].length == 4 : "Board size is not 4x4";

        // Test fillBoard() and emptySpace()
        board.fillBoard(2, 3, "X");
        assert board.getBoard()[1][2].equals("X") : "fillBoard() is not working properly";
        assert !GameLogic.emptySpace(1, 2, board) : "emptySpace() is not working properly";

        // Additional board testing can be added based on specific requirements
    }

    /**
     * Test GameLogic class
     */
    public static void testGameLogicClass() {
        System.out.println("Testing GameLogic class...");

        // Test horizontal()
        Board boardHorizontal = new Board(5);
        boardHorizontal.fillBoard(3, 1, "X");
        boardHorizontal.fillBoard(3, 2, "X");
        boardHorizontal.fillBoard(3, 3, "X");
        assert GameLogic.horizontal(boardHorizontal, "X", 3) : "GameLogic.horizontal() is not working properly";

        // Test vertical()
        Board boardVertical = new Board(6);
        boardVertical.fillBoard(1, 4, "&");
        boardVertical.fillBoard(2, 4, "&");
        boardVertical.fillBoard(3, 4, "&");
        assert GameLogic.vertical(boardVertical, "&", 3) : "GameLogic.vertical() is not working properly";

        // Test right diagonal()
        Board boardRightDiagonal = new Board(4);
        boardRightDiagonal.fillBoard(1, 1, "O");
        boardRightDiagonal.fillBoard(2, 2, "O");
        boardRightDiagonal.fillBoard(3, 3, "O");
        assert GameLogic.diagonal(boardRightDiagonal, "O", 3) : "GameLogic.diagonal() is not working properly";

        // Test left diagonal()
        Board boardLeftDiagonal = new Board(4);
        boardLeftDiagonal.fillBoard(1, 3, "X");
        boardLeftDiagonal.fillBoard(2, 2, "X");
        boardLeftDiagonal.fillBoard(3, 1, "X");
        assert GameLogic.diagonal(boardLeftDiagonal, "X", 3) : "GameLogic.diagonal() is not working properly";

        // Test diagonal with a different marker
        Board boardDiagonalDifferentMarker = new Board(4);
        boardDiagonalDifferentMarker.fillBoard(1, 1, "X");
        boardDiagonalDifferentMarker.fillBoard(2, 2, "X");
        boardDiagonalDifferentMarker.fillBoard(3, 3, "X");
        assert !GameLogic.diagonal(boardDiagonalDifferentMarker, "O", 3) : "GameLogic.diagonal() is not working properly";

        // Test for almost horizontal match but not enough to win
        Board boardAlmostHorizontal = new Board(5);
        boardAlmostHorizontal.fillBoard(3, 1, "O");
        boardAlmostHorizontal.fillBoard(3, 2, "O");
        boardAlmostHorizontal.fillBoard(3, 4, "O");
        assert !GameLogic.horizontal(boardAlmostHorizontal, "O", 3) : "GameLogic.horizontal() is not working properly";

        // Test for almost vertical match but not enough to win
        Board boardAlmostVertical = new Board(6);
        boardAlmostVertical.fillBoard(1, 4, "X");
        boardAlmostVertical.fillBoard(2, 4, "X");
        boardAlmostVertical.fillBoard(4, 4, "X");
        assert !GameLogic.vertical(boardAlmostVertical, "X", 3) : "GameLogic.vertical() is not working properly";
    }

    /**
     * Test Helper class
     */
    public static void testHelperClass() {
        System.out.println("Testing Helper class...");

        // Test promptUserInput()
        int userInput = Helper.promptUserInput("Enter a number (1-5): ", 1, 5);
        assert userInput >= 1 && userInput <= 5 : "Helper.promptUserInput() is not working properly";
    }
}
