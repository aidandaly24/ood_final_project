package src.state;

import src.factory.ComparisonFactory;
import src.factory.Comparison;

import java.util.Scanner;

public class PerformingComparisonState implements State {

    @Override
    public void handleInput(AppContext context, String input) {
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
            return;
        }

        String result = comparison.compare(entity1, entity2);
        System.out.println(result);

        // Transition back to ReadyForComparisonState
        context.setState(new ReadyForComparisonState());
    }
}
