package src;

import java.util.Scanner;

import src.state.AppContext;

public class Driver {
        public static void main(String[] args) {
                System.out.println(
                                "How this program works:\n\n To start - it's important to understand that this app maintains state so you can switch between commands at will.");
                System.out.println(
                                "If this is your first time running this program you should always run fetch first.");
                System.out.println(
                                "Compare - allows you to compare data that you have. You can compare data between teams. If you try to compare data that you don't have you will be asked to choose again.");
                System.out.println("Quit - allows you to quit the program at any moment.");

                Scanner scanner = new Scanner(System.in);

                System.out.println("\nEnter command (compare, quit): ");
                String input = scanner.nextLine();

                AppContext context = new AppContext(input);

                scanner.close();
        }
}
