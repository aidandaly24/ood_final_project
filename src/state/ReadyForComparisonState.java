package src.state;

import java.util.Scanner;

public class ReadyForComparisonState implements State {

    @Override
    public void handleInput(AppContext context) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command (fetch, compare, quit):")
        String next_command = scanner.nextLine();

        if ("fetch".equalsIgnoreCase(next_command)) {
            context.setState(new FetchingYearsState());
            context.handleInput();
        } else if ("compare".equalsIgnoreCase(input)) {
            context.setState(new PerformingComparisonState());
            context.handleInput();
        } else if ("quit".equalsIgnoreCase(next_command)) {
            context.setState(new QuittingState());
            context.handleInput();
        } else {
            System.out.println("Unknown command. Available commands: 'compare', 'fetch', 'quit'.");
        }
    }
}
