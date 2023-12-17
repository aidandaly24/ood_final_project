package src.adapter;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public List<PlayerSeasonBean> seasons;

    private double averageAge;
    private double averageMinutesPlayed;
    private double averageFieldGoals;
    private double averageFieldGoalAttempts;
    private double averageFieldGoalPercentage;
    private double averageThreePointFieldGoals;
    private double averageThreePointFieldGoalAttempts;
    private double averageThreePointFieldGoalPercentage;
    private double averageTwoPointFieldGoals;
    private double averageTwoPointFieldGoalAttempts;
    private double averageTwoPointFieldGoalPercentage;
    private double averageEffectiveFieldGoalPercentage;
    private double averageFreeThrows;
    private double averageFreeThrowAttempts;
    private double averageFreeThrowPercentage;
    private double averageOffensiveRebounds;
    private double averageDefensiveRebounds;
    private double averageTotalRebounds;
    private double averageAssists;
    private double averageSteals;
    private double averageBlocks;
    private double averageTurnovers;
    private double averagePersonalFouls;
    private double averagePoints;

    public Player(String name) {
        this.name = name;
        this.seasons = new ArrayList<>();
    }

    public void addAverages(double averageAge,
            double averageMinutesPlayed,
            double averageFieldGoals, double averageFieldGoalAttempts, double averageFieldGoalPercentage,
            double averageThreePointFieldGoals, double averageThreePointFieldGoalAttempts,
            double averageThreePointFieldGoalPercentage,
            double averageTwoPointFieldGoals, double averageTwoPointFieldGoalAttempts,
            double averageTwoPointFieldGoalPercentage,
            double averageEffectiveFieldGoalPercentage,
            double averageFreeThrows, double averageFreeThrowAttempts, double averageFreeThrowPercentage,
            double averageOffensiveRebounds, double averageDefensiveRebounds, double averageTotalRebounds,
            double averageAssists, double averageSteals, double averageBlocks,
            double averageTurnovers, double averagePersonalFouls, double averagePoints) {
        this.averageAge = averageAge;
        this.averageMinutesPlayed = averageMinutesPlayed;
        this.averageFieldGoals = averageFieldGoals;
        this.averageFieldGoalAttempts = averageFieldGoalAttempts;
        this.averageFieldGoalPercentage = averageFieldGoalPercentage;
        this.averageThreePointFieldGoals = averageThreePointFieldGoals;
        this.averageThreePointFieldGoalAttempts = averageThreePointFieldGoalAttempts;
        this.averageThreePointFieldGoalPercentage = averageThreePointFieldGoalPercentage;
        this.averageTwoPointFieldGoals = averageTwoPointFieldGoals;
        this.averageTwoPointFieldGoalAttempts = averageTwoPointFieldGoalAttempts;
        this.averageTwoPointFieldGoalPercentage = averageTwoPointFieldGoalPercentage;
        this.averageEffectiveFieldGoalPercentage = averageEffectiveFieldGoalPercentage;
        this.averageFreeThrows = averageFreeThrows;
        this.averageFreeThrowAttempts = averageFreeThrowAttempts;
        this.averageFreeThrowPercentage = averageFreeThrowPercentage;
        this.averageOffensiveRebounds = averageOffensiveRebounds;
        this.averageDefensiveRebounds = averageDefensiveRebounds;
        this.averageTotalRebounds = averageTotalRebounds;
        this.averageAssists = averageAssists;
        this.averageSteals = averageSteals;
        this.averageBlocks = averageBlocks;
        this.averageTurnovers = averageTurnovers;
        this.averagePersonalFouls = averagePersonalFouls;
        this.averagePoints = averagePoints;
    }

    public void addSeason(PlayerSeasonBean season) {
        seasons.add(season);
    }

    public String getName() {
        return name;
    }

    public double getAverageAge() {
        return averageAge;
    }

    public double getAverageMinutesPlayed() {
        return averageMinutesPlayed;
    }

    public double getAverageFieldGoals() {
        return averageFieldGoals;
    }

    public double getAverageFieldGoalAttempts() {
        return averageFieldGoalAttempts;
    }

    public double getAverageFieldGoalPercentage() {
        return averageFieldGoalPercentage;
    }

    public double getAverageThreePointFieldGoals() {
        return averageThreePointFieldGoals;
    }

    public double getAverageThreePointFieldGoalAttempts() {
        return averageThreePointFieldGoalAttempts;
    }

    public double getAverageThreePointFieldGoalPercentage() {
        return averageThreePointFieldGoalPercentage;
    }

    public double getAverageTwoPointFieldGoals() {
        return averageTwoPointFieldGoals;
    }

    public double getAverageTwoPointFieldGoalAttempts() {
        return averageTwoPointFieldGoalAttempts;
    }

    public double getAverageTwoPointFieldGoalPercentage() {
        return averageTwoPointFieldGoalPercentage;
    }

    public double getAverageEffectiveFieldGoalPercentage() {
        return averageEffectiveFieldGoalPercentage;
    }

    public double getAverageFreeThrows() {
        return averageFreeThrows;
    }

    public double getAverageFreeThrowAttempts() {
        return averageFreeThrowAttempts;
    }

    public double getAverageFreeThrowPercentage() {
        return averageFreeThrowPercentage;
    }

    public double getAverageOffensiveRebounds() {
        return averageOffensiveRebounds;
    }

    public double getAverageDefensiveRebounds() {
        return averageDefensiveRebounds;
    }

    public double getAverageTotalRebounds() {
        return averageTotalRebounds;
    }

    public double getAverageAssists() {
        return averageAssists;
    }

    public double getAverageSteals() {
        return averageSteals;
    }

    public double getAverageBlocks() {
        return averageBlocks;
    }

    public double getAverageTurnovers() {
        return averageTurnovers;
    }

    public double getAveragePersonalFouls() {
        return averagePersonalFouls;
    }

    public double getAveragePoints() {
        return averagePoints;
    }

}
