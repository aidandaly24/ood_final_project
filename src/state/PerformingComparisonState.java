package src.state;

import src.factory.ComparisonFactory;
import src.factory.Comparison;
import src.adapter.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

public class PerformingComparisonState implements State {

    @Override
    public void handleInput(AppContext context) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of comparison ('player' or 'team'): ");
        String comparisonTypeInput = scanner.nextLine();

        while (!(comparisonTypeInput.toLowerCase().equals("player"))
                && !(comparisonTypeInput.toLowerCase().equals("team"))) {
            System.out.println("Enter the type of comparison ('player' or 'team'): ");
            comparisonTypeInput = scanner.nextLine();
            System.out.println("\nThis was an incorrect input");
        }

        if (comparisonTypeInput.toLowerCase().equals("player")) {
            System.out.println("\nWhen entering a player's name please input their full name as found on NBA.com");
        } else {
            System.out.println(
                    "\nWhen entering a team's name please input the team's acronym followed by a space and the season.");
            System.out.println("For example: BOS 1997-98");
        }

        try {
            CSVAdapter adapter = CSVAdapter.getInstance();
            HashMap<String, Player> players = adapter.getAveragePlayers();
            HashMap<String, Team> teams = adapter.getTeamSeasons();
            System.out.println("\nEnter the first entity for comparison:");
            String entity1 = scanner.nextLine().toLowerCase();

            while (comparisonTypeInput.toLowerCase().equals("team")) {
                String[] entity1Parts = entity1.trim().split(" ");
                while (!teams.containsKey(entity1Parts[0] + "-" + entity1Parts[1])) {
                    System.out.println(
                            "\nUnfortunately this data is not offered make sure that you enter team acronym followed by a space and the year");
                    System.out.println("Enter the first entity for comparison:");
                    entity1 = scanner.nextLine().toLowerCase();
                    entity1Parts = entity1.trim().split(" ");
                }
                entity1 = entity1Parts[0] + "-" + entity1Parts[1];
                break;
            }

            while (comparisonTypeInput.toLowerCase().equals("player") && !players.containsKey(entity1)) {
                System.out.println(
                        "\nThis player was not found in the database. Ensure that you are entering the player's full name.");
                System.out.println("Enter the first entity for comparison:");
                entity1 = scanner.nextLine().toLowerCase();
            }

            System.out.println("Enter the second entity for comparison:");
            String entity2 = scanner.nextLine().toLowerCase();

            while (comparisonTypeInput.toLowerCase().equals("team")) {
                String[] entity2Parts = entity2.trim().split(" ");
                while (!teams.containsKey(entity2Parts[0] + "-" + entity2Parts[1])) {
                    System.out.println(
                            "\nUnfortunately this data is not offered make sure that you enter team acronym followed by a space and the year");
                    System.out.println("Enter the first entity for comparison:");
                    entity2 = scanner.nextLine().toLowerCase();
                    entity2Parts = entity1.trim().split(" ");
                }
                entity2 = entity2Parts[0] + "-" + entity2Parts[1];
                break;
            }

            while (comparisonTypeInput.toLowerCase().equals("player") && !players.containsKey(entity2)) {
                System.out.println(
                        "\nThis player was not found in the database. Ensure that you are entering the player's full name.");
                System.out.println("Enter the first entity for comparison:");
                entity2 = scanner.nextLine().toLowerCase();
            }

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

        } catch (IOException e) {
            System.out.println("There was an error attaining data for players.");
        }

        // Transition back to ReadyForComparisonState
        context.setState(new ReadyForComparisonState());
        context.handleInput();
    }
}
