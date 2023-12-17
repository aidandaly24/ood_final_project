package src.factory;

import java.io.IOException;

import src.adapter.CSVAdapter;
import src.adapter.Player;
import src.strategy.PlayerPrintStrategy;

public class PlayerComparison implements Comparison {

        // Player 1 statistics
        public String p1Name;
        public double p1AveragePoints;
        public double p1AverageAssists;
        public double p1AverageTotalRebounds;
        public double p1AverageFieldGoalPercentage;
        public double p1AverageThreePointFieldGoalPercentage;
        public double p1AverageFreeThrowPercentage;
        public double p1AverageSteals;
        public double p1AverageBlocks;
        public double p1AverageMinutesPlayed;
        public double p1AverageTurnovers;
        public double p1AveragePersonalFouls;
        public double p1AverageAge;

        // Player 2 statistics
        public String p2Name;
        public double p2AveragePoints;
        public double p2AverageAssists;
        public double p2AverageTotalRebounds;
        public double p2AverageFieldGoalPercentage;
        public double p2AverageThreePointFieldGoalPercentage;
        public double p2AverageFreeThrowPercentage;
        public double p2AverageSteals;
        public double p2AverageBlocks;
        public double p2AverageMinutesPlayed;
        public double p2AverageTurnovers;
        public double p2AveragePersonalFouls;
        public double p2AverageAge;

        // Player 1 Advanced statistics
        public double p1PointsPerAttempt;
        public double p1TrueShootingPercentage;
        public double p1ThreePointReliance;
        public double p1AssistTurnoverRatio;
        public double p1ReboundsPerMinute;
        public double p1PER;
        public double p1AgePerformanceRatio;

        // Player 2 Advanced statistics
        public double p2PointsPerAttempt;
        public double p2TrueShootingPercentage;
        public double p2ThreePointReliance;
        public double p2AssistTurnoverRatio;
        public double p2ReboundsPerMinute;
        public double p2PER;
        public double p2AgePerformanceRatio;

        @Override
        public void compare(String player1, String player2) throws IOException {
                CSVAdapter adapter = CSVAdapter.getInstance();
                Player p1 = adapter.getAveragePlayers().get(player1);
                Player p2 = adapter.getAveragePlayers().get(player2);
                assignValues(p1, p2);

                // Calculate and assign advanced statistics for Player 1
                p1PointsPerAttempt = p1.getAveragePoints() / p1.getAverageFieldGoalAttempts();
                p1TrueShootingPercentage = calculateTrueShootingPercentage(p1);
                p1ThreePointReliance = p1.getAverageThreePointFieldGoalAttempts() / p1.getAverageFieldGoalAttempts();
                p1AssistTurnoverRatio = p1.getAverageAssists() / p1.getAverageTurnovers();
                p1ReboundsPerMinute = p1.getAverageTotalRebounds() / p1.getAverageMinutesPlayed();
                p1PER = calculatePER(p1);
                p1AgePerformanceRatio = calculateAgePerformanceRatio(p1);

                // Calculate and assign advanced statistics for Player 2
                p2PointsPerAttempt = p2.getAveragePoints() / p2.getAverageFieldGoalAttempts();
                p2TrueShootingPercentage = calculateTrueShootingPercentage(p2);
                p2ThreePointReliance = p2.getAverageThreePointFieldGoalAttempts() / p2.getAverageFieldGoalAttempts();
                p2AssistTurnoverRatio = p2.getAverageAssists() / p2.getAverageTurnovers();
                p2ReboundsPerMinute = p2.getAverageTotalRebounds() / p2.getAverageMinutesPlayed();
                p2PER = calculatePER(p2);
                p2AgePerformanceRatio = calculateAgePerformanceRatio(p2);

                PlayerPrintStrategy print = new PlayerPrintStrategy(this);
                print.print();

        }

        public double calculateTrueShootingPercentage(Player player) {
                return (player.getAveragePoints()
                                / (2 * (player.getAverageFieldGoalAttempts()
                                                + 0.44 * player.getAverageFreeThrowAttempts())))
                                * 100;
        }

        public double calculatePER(Player player) {
                double factor = (2 / 3) - (0.5 * (player.getAverageAssists() / player.getAverageFieldGoalAttempts()))
                                / (2 * (player.getAverageFieldGoalAttempts() / player.getAverageFreeThrowAttempts()));

                double VOP = player.getAveragePoints() / (player.getAverageFieldGoalAttempts()
                                + player.getAverageTurnovers()
                                + 0.44 * player.getAverageFreeThrowAttempts() + player.getAverageOffensiveRebounds());

                double uPER = (1 / player.getAverageMinutesPlayed()) *
                                (player.getAveragePoints()
                                                + player.getAverageSteals()
                                                + player.getAverageBlocks()
                                                - player.getAverageFieldGoalAttempts()
                                                - player.getAverageTurnovers()
                                                + factor * player.getAverageAssists()
                                                + (2 - factor) * player.getAverageOffensiveRebounds()
                                                + (1 - 1.07 * VOP)
                                                                * (player.getAverageDefensiveRebounds() - player
                                                                                .getAverageOffensiveRebounds()));

                return uPER * (player.getAverageMinutesPlayed() / (player.getAverageFieldGoalAttempts()
                                + player.getAverageFreeThrowAttempts() + player.getAverageTurnovers()));
        }

        public double calculateAgePerformanceRatio(Player player) {
                double performanceScore = player.getAveragePoints() + player.getAverageAssists()
                                + player.getAverageTotalRebounds();
                return performanceScore / player.getAverageAge();
        }

        private void assignValues(Player p1, Player p2) {
                // Assign values to player 1 statistics
                p1Name = p1.getName();
                p1AveragePoints = p1.getAveragePoints();
                p1AverageAssists = p1.getAverageAssists();
                p1AverageTotalRebounds = p1.getAverageTotalRebounds();
                p1AverageFieldGoalPercentage = p1.getAverageFieldGoalPercentage();
                p1AverageThreePointFieldGoalPercentage = p1.getAverageThreePointFieldGoalPercentage();
                p1AverageFreeThrowPercentage = p1.getAverageFreeThrowPercentage();
                p1AverageSteals = p1.getAverageSteals();
                p1AverageBlocks = p1.getAverageBlocks();
                p1AverageMinutesPlayed = p1.getAverageMinutesPlayed();
                p1AverageTurnovers = p1.getAverageTurnovers();
                p1AveragePersonalFouls = p1.getAveragePersonalFouls();
                p1AverageAge = p1.getAverageAge();

                // Assign values to player 2 statistics
                p2Name = p2.getName();
                p2AveragePoints = p2.getAveragePoints();
                p2AverageAssists = p2.getAverageAssists();
                p2AverageTotalRebounds = p2.getAverageTotalRebounds();
                p2AverageFieldGoalPercentage = p2.getAverageFieldGoalPercentage();
                p2AverageThreePointFieldGoalPercentage = p2.getAverageThreePointFieldGoalPercentage();
                p2AverageFreeThrowPercentage = p2.getAverageFreeThrowPercentage();
                p2AverageSteals = p2.getAverageSteals();
                p2AverageBlocks = p2.getAverageBlocks();
                p2AverageMinutesPlayed = p2.getAverageMinutesPlayed();
                p2AverageTurnovers = p2.getAverageTurnovers();
                p2AveragePersonalFouls = p2.getAveragePersonalFouls();
                p2AverageAge = p2.getAverageAge();
        }

}
