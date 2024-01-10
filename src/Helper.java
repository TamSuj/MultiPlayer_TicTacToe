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
}
