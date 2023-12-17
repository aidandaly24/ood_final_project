package src.state;

import java.util.Scanner;

public class ReadyForComparisonState implements State {

    @Override
    public void handleInput(AppContext context) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command (compare, quit):");
        String next_command = scanner.nextLine();

        if ("compare".equalsIgnoreCase(next_command)) {
            context.setState(new PerformingComparisonState());
            context.handleInput();
        } else if ("quit".equalsIgnoreCase(next_command)) {
            context.setState(new QuittingState());
            context.handleInput();
        } else {
            System.out.println("Unknown command. Available commands: 'compare', 'fetch', 'quit'.");
        }
        scanner.close();
    }
}
