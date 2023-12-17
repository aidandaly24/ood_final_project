package src.state;

import src.factory.ComparisonFactory;
import src.factory.Comparison;
import src.adapter.CSVAdapter;

import java.io.IOException;
import java.util.Scanner;

public class PerformingComparisonState implements State {

    @Override
    public void handleInput(AppContext context) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of comparison ('player' or 'team'): ");
        String comparisonTypeInput = scanner.nextLine();

        System.out.println("Enter the first entity for comparison:");
        String entity1 = scanner.nextLine();

        System.out.println("Enter the second entity for comparison:");
        String entity2 = scanner.nextLine();

        Comparison comparison;
        if ("player".equalsIgnoreCase(comparisonTypeInput)) {
            comparison = new ComparisonFactory().getComparison(ComparisonFactory.ComparisonType.PLAYER);
        } else if ("team".equalsIgnoreCase(comparisonTypeInput)) {
            comparison = new ComparisonFactory().getComparison(ComparisonFactory.ComparisonType.TEAM);
        } else {
            System.out.println("Invalid comparison type.");
            scanner.close();
            return;
        }
        try {
            comparison.compare(entity1, entity2);
        } catch (IOException e) {
            System.out.println("Unfortunately there was an error completing this comparison.");
        }
        // Transition back to ReadyForComparisonState
        context.setState(new ReadyForComparisonState());
        context.handleInput();
    }
}
