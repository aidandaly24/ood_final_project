package src.strategy;

import java.util.List;
import src.factory.TeamComparison;

public class TeamPrintStrategy implements PrintStrategy {

        private TeamComparison teamComparison;

        public TeamPrintStrategy(TeamComparison teamComparison) {
                this.teamComparison = teamComparison;
        }

        @Override
        public void print() {
                System.out.println("Team Comparison");
                System.out.println("----------------------------------------------------------------");
                System.out.printf("%-40s %-20s %-20s\n", "Statistic", "Team 1", "Team 2");
                System.out.println("----------------------------------------------------------------");

                // Basic Statistics
                System.out.printf("%-40s %-20s %-20s\n", "Name", teamComparison.t1Name, teamComparison.t2Name);
                System.out.printf("%-40s %-20s %-20s\n", "Season", teamComparison.t1Season, teamComparison.t2Season);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Average Points", teamComparison.t1AveragePoints,
                                teamComparison.t2AveragePoints);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Average Assists", teamComparison.t1AverageAssists,
                                teamComparison.t2AverageAssists);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Average Total Rebounds",
                                teamComparison.t1AverageTotalRebounds,
                                teamComparison.t2AverageTotalRebounds);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Average Field Goal Percentage",
                                teamComparison.t1AverageFieldGoalPercentage,
                                teamComparison.t2AverageFieldGoalPercentage);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Average 3PFG%",
                                teamComparison.t1AverageThreePointFieldGoalPercentage,
                                teamComparison.t2AverageThreePointFieldGoalPercentage);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Average Free Throw Percentage",
                                teamComparison.t1AverageFreeThrowPercentage,
                                teamComparison.t2AverageFreeThrowPercentage);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Average Steals", teamComparison.t1AverageSteals,
                                teamComparison.t2AverageSteals);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Average Blocks", teamComparison.t1AverageBlocks,
                                teamComparison.t2AverageBlocks);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Average Minutes Played",
                                teamComparison.t1AverageMinutesPlayed,
                                teamComparison.t2AverageMinutesPlayed);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Average Turnovers", teamComparison.t1AverageTurnovers,
                                teamComparison.t2AverageTurnovers);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Average Personal Fouls",
                                teamComparison.t1AveragePersonalFouls,
                                teamComparison.t2AveragePersonalFouls);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Average Age", teamComparison.t1AverageAge,
                                teamComparison.t2AverageAge);

                // Advanced Statistics
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Estimate Possessions",
                                teamComparison.t1EstimatePossessions,
                                teamComparison.t2EstimatePossessions);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Offensive Efficiency",
                                teamComparison.t1OffensiveEfficiency,
                                teamComparison.t2OffensiveEfficiency);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Shot Distribution", teamComparison.t1ShotDistribution,
                                teamComparison.t2ShotDistribution);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Shot Selection Efficiency",
                                teamComparison.t1ShotSelectionEfficiency, teamComparison.t2ShotSelectionEfficiency);
                System.out.printf("%-40s %-20.2f %-20.2f\n", "Turnover Ratio", teamComparison.t1TurnoverRatio,
                                teamComparison.t2TurnoverRatio);

                System.out.println("----------------------------------------------------------------");
        }
}
