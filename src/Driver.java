package src;

import src.state.AppContext;
import src.state.QuittingState;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        AppContext context = new AppContext();
        Scanner scanner = new Scanner(System.in);

        System.out.println("How this program works:\n\n To start - it's important to understand that this app maintains state so you can switch between commands at will.");
        System.out.println("If this is your first time running this program you should always run fetch first.");
        System.out.println("Fetch - allows you to fetch data for a certain range of years, this downloads data from the internet and creates a CSV file for player data in that year.");
        System.out.println("Compare - allows you to compare data that you have. You can compare data between teams. If you try to compare data that you don't have you will be asked to choose again.");
        System.out.println("Quit - allows you to quit the program at any moment.");

        while (true) {
            System.out.println("Enter command (fetch, compare, quit): ");
            String input = scanner.nextLine();
            context.handleInput(input);

            if (context instanceOf QuittingState) {
                break;
            }
        }

        scanner.close();
    }
}
