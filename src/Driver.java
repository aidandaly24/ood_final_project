package src;

import java.util.Scanner;

import src.state.AppContext;

public class Driver {
        public static void main(String[] args) {
                System.out.println(
                                "How this program works:\n\n To start - it's important to understand that this app maintains state so you can switch between commands at will.");
                System.out.println(
                                "If this is your first time running this program it may be helpful to have a list of players and teams up in another tab.");
                System.out.println("Data are available from the years 1997-98 season through the 2022-23 season.");
                System.out.println(
                                "Compare - allows you to compare data. If you try to compare data that is not present you will be prompted to enter another entity.");
                System.out.println("Quit - allows you to quit the program at any moment.");

                Scanner scanner = new Scanner(System.in);

                System.out.println("\nEnter command (compare, quit): ");
                String input = scanner.nextLine();

                AppContext context = new AppContext(input);

                scanner.close();
        }
}
