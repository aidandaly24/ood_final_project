package src.strategy;

import java.util.List;
import src.factory.PlayerComparison;

public class PlayerPrintStrategy implements PrintStrategy {
    private PlayerComparison playerComparison;

    public PlayerPrintStrategy(PlayerComparison playerComparison) {
        this.playerComparison = playerComparison;
    }

    @Override
    public void print() {
        System.out.println("Player Comparison");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-30s %-15s %-15s\n", "Statistic", playerComparison.p1Name, playerComparison.p2Name);
        System.out.println("----------------------------------------------------------------");

        // Printing out the statistics directly
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Average Points", playerComparison.p1AveragePoints,
                playerComparison.p2AveragePoints);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Average Assists", playerComparison.p1AverageAssists,
                playerComparison.p2AverageAssists);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Average Total Rebounds", playerComparison.p1AverageTotalRebounds,
                playerComparison.p2AverageTotalRebounds);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Average Field Goal Percentage",
                playerComparison.p1AverageFieldGoalPercentage, playerComparison.p2AverageFieldGoalPercentage);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Average Three Point Field Goal Percentage",
                playerComparison.p1AverageThreePointFieldGoalPercentage,
                playerComparison.p2AverageThreePointFieldGoalPercentage);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Average Free Throw Percentage",
                playerComparison.p1AverageFreeThrowPercentage, playerComparison.p2AverageFreeThrowPercentage);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Average Steals", playerComparison.p1AverageSteals,
                playerComparison.p2AverageSteals);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Average Blocks", playerComparison.p1AverageBlocks,
                playerComparison.p2AverageBlocks);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Average Minutes Played", playerComparison.p1AverageMinutesPlayed,
                playerComparison.p2AverageMinutesPlayed);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Average Turnovers", playerComparison.p1AverageTurnovers,
                playerComparison.p2AverageTurnovers);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Average Personal Fouls", playerComparison.p1AveragePersonalFouls,
                playerComparison.p2AveragePersonalFouls);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Average Age", playerComparison.p1AverageAge,
                playerComparison.p2AverageAge);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Points Per Attempt", playerComparison.p1PointsPerAttempt,
                playerComparison.p2PointsPerAttempt);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "True Shooting Percentage",
                playerComparison.p1TrueShootingPercentage, playerComparison.p2TrueShootingPercentage);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Three Point Reliance", playerComparison.p1ThreePointReliance,
                playerComparison.p2ThreePointReliance);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Assist Turnover Ratio", playerComparison.p1AssistTurnoverRatio,
                playerComparison.p2AssistTurnoverRatio);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Rebounds Per Minute", playerComparison.p1ReboundsPerMinute,
                playerComparison.p2ReboundsPerMinute);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "PER", playerComparison.p1PER, playerComparison.p2PER);
        System.out.printf("%-30s %-15.2f %-15.2f\n", "Age Performance Ratio", playerComparison.p1AgePerformanceRatio,
                playerComparison.p2AgePerformanceRatio);

        System.out.println("----------------------------------------------------------------");
    }
}
