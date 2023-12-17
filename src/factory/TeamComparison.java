package src.factory;

import java.io.IOException;
import java.util.HashMap;

import src.adapter.CSVAdapter;
import src.adapter.Team;
import src.strategy.TeamPrintStrategy;

public class TeamComparison implements Comparison {

    // Team 1 statistics
    public String t1Name;
    public String t1Season;
    public double t1AveragePoints;
    public double t1AverageAssists;
    public double t1AverageTotalRebounds;
    public double t1AverageFieldGoalPercentage;
    public double t1AverageThreePointFieldGoalPercentage;
    public double t1AverageFreeThrowPercentage;
    public double t1AverageSteals;
    public double t1AverageBlocks;
    public double t1AverageMinutesPlayed;
    public double t1AverageTurnovers;
    public double t1AveragePersonalFouls;
    public double t1AverageAge;

    // Team 2 statistics
    public String t2Name;
    public String t2Season;
    public double t2AveragePoints;
    public double t2AverageAssists;
    public double t2AverageTotalRebounds;
    public double t2AverageFieldGoalPercentage;
    public double t2AverageThreePointFieldGoalPercentage;
    public double t2AverageFreeThrowPercentage;
    public double t2AverageSteals;
    public double t2AverageBlocks;
    public double t2AverageMinutesPlayed;
    public double t2AverageTurnovers;
    public double t2AveragePersonalFouls;
    public double t2AverageAge;

    // Team 1 Advanced statistics
    public double t1EstimatePossessions;
    public double t1OffensiveEfficiency;
    public double t1ShotDistribution;
    public double t1ShotSelectionEfficiency;
    public double t1TurnoverRatio;

    // Team 2 Advanced statistics
    public double t2EstimatePossessions;
    public double t2OffensiveEfficiency;
    public double t2ShotDistribution;
    public double t2ShotSelectionEfficiency;
    public double t2TurnoverRatio;

    @Override
    public void compare(String team1, String team2) throws IOException {
        // Implement team comparison logic here
        CSVAdapter adapter = CSVAdapter.getInstance();
        HashMap<String, Team> teams = adapter.getTeamSeasons();

        if (!teams.containsKey(team1) || !teams.containsKey(team2)) {
            System.out.println(
                    "Unfortunately there has been an unforseen error with retrieving data for these teams. Please rerun the program.");
            System.exit(0);
        }

        Team t1 = teams.get(team1);
        Team t2 = teams.get(team2);

        adapter.printTeams();

        assignValues(t1, t2);

        t1EstimatePossessions = estimatePossessions(t1);
        t2EstimatePossessions = estimatePossessions(t2);

        t1OffensiveEfficiency = calculateOffensiveEfficiency(t1);
        t2OffensiveEfficiency = calculateOffensiveEfficiency(t2);

        t1ShotDistribution = calculateShotDistribution(t1);
        t2ShotDistribution = calculateShotDistribution(t2);

        t1ShotSelectionEfficiency = calculateShotSelectionEfficiency(t1);
        t2ShotSelectionEfficiency = calculateShotSelectionEfficiency(t2);

        t1TurnoverRatio = calculateTurnoverRatio(t1);
        t2TurnoverRatio = calculateTurnoverRatio(t2);

        TeamPrintStrategy print = new TeamPrintStrategy(this);
        print.print();

    }

    // Estimates the number of possessions for a team
    private static double estimatePossessions(Team team) {
        return team.getAverageFieldGoalAttempts() + 0.44 * team.getAverageFreeThrowAttempts()
                + team.getAverageTurnovers();
    }

    // Calculates Offensive Efficiency
    public static double calculateOffensiveEfficiency(Team team) {
        double possessions = estimatePossessions(team);
        return (team.getAveragePoints() / possessions) * 100;
    }

    // Calculates Shot Distribution
    public static double calculateShotDistribution(Team team) {
        return (team.getAverageThreePointFieldGoalAttempts() / team.getAverageFieldGoalAttempts()) * 100;
    }

    // Calculates Shot Selection Efficiency
    public static double calculateShotSelectionEfficiency(Team team) {
        double avgPointsTwoPointer = 2
                * (team.getAverageTwoPointFieldGoals() / team.getAverageTwoPointFieldGoalAttempts());
        double avgPointsThreePointer = 3
                * (team.getAverageThreePointFieldGoals() / team.getAverageThreePointFieldGoalAttempts());
        return avgPointsTwoPointer > avgPointsThreePointer ? avgPointsTwoPointer : avgPointsThreePointer;
    }

    // Calculates Turnover Ratio
    public static double calculateTurnoverRatio(Team team) {
        double possessions = estimatePossessions(team);
        return (team.getAverageTurnovers() / possessions) * 100;
    }

    private void assignValues(Team t1, Team t2) {
        // Assign values to team 1 statistics
        System.out.println(t1.name);
        t1Name = t1.getName();
        t1Season = t1.getSeason();
        t1AveragePoints = t1.getAveragePoints();
        t1AverageAssists = t1.getAverageAssists();
        t1AverageTotalRebounds = t1.getAverageTotalRebounds();
        t1AverageFieldGoalPercentage = t1.getAverageFieldGoalPercentage();
        t1AverageThreePointFieldGoalPercentage = t1.getAverageThreePointFieldGoalPercentage();
        t1AverageFreeThrowPercentage = t1.getAverageFreeThrowPercentage();
        t1AverageSteals = t1.getAverageSteals();
        t1AverageBlocks = t1.getAverageBlocks();
        t1AverageMinutesPlayed = t1.getAverageMinutesPlayed();
        t1AverageTurnovers = t1.getAverageTurnovers();
        t1AveragePersonalFouls = t1.getAveragePersonalFouls();
        t1AverageAge = t1.getAverageAge();

        // Assign values to team 2 statistics
        t2Name = t2.getName();
        t2Season = t2.getSeason();
        t2AveragePoints = t2.getAveragePoints();
        t2AverageAssists = t2.getAverageAssists();
        t2AverageTotalRebounds = t2.getAverageTotalRebounds();
        t2AverageFieldGoalPercentage = t2.getAverageFieldGoalPercentage();
        t2AverageThreePointFieldGoalPercentage = t2.getAverageThreePointFieldGoalPercentage();
        t2AverageFreeThrowPercentage = t2.getAverageFreeThrowPercentage();
        t2AverageSteals = t2.getAverageSteals();
        t2AverageBlocks = t2.getAverageBlocks();
        t2AverageMinutesPlayed = t2.getAverageMinutesPlayed();
        t2AverageTurnovers = t2.getAverageTurnovers();
        t2AveragePersonalFouls = t2.getAveragePersonalFouls();
        t2AverageAge = t2.getAverageAge();
    }

}
