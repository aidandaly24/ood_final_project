package src.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CSVAdapter {

    private static CSVAdapter instance;
    private List<PlayerSeasonBean> playerSeasons;
    private HashMap<String, Player> allPlayers;
    private HashMap<String, Team> allTeams;

    private CSVAdapter() throws IOException {
        this.playerSeasons = readCsv();
        this.allPlayers = getPlayers();
        this.allTeams = getTeams();
    }

    public static CSVAdapter getInstance() throws IOException {
        if (instance == null) {
            instance = new CSVAdapter();
        }
        return instance;
    }

    private HashMap<String, Player> getPlayers() {
        HashMap<String, Player> playersMap = new HashMap<>();

        for (PlayerSeasonBean season : playerSeasons) {
            String playerName = season.getPlayer();
            Player player = playersMap.get(playerName);

            if (player == null) {
                player = new Player(playerName);
                playersMap.put(playerName, player);
            }

            player.addSeason(season);
        }

        for (Player p : playersMap.values()) {
            List<Double> averages = computeAverages(p.seasons);
            p.addAverages(
                    averages.get(0), // averageAge
                    averages.get(1), // averageMinutesPlayed
                    averages.get(2), // averageFieldGoals
                    averages.get(3), // averageFieldGoalAttempts
                    averages.get(4), // averageFieldGoalPercentage
                    averages.get(5), // averageThreePointFieldGoals
                    averages.get(6), // averageThreePointFieldGoalAttempts
                    averages.get(7), // averageThreePointFieldGoalPercentage
                    averages.get(8), // averageTwoPointFieldGoals
                    averages.get(9), // averageTwoPointFieldGoalAttempts
                    averages.get(10), // averageTwoPointFieldGoalPercentage
                    averages.get(11), // averageEffectiveFieldGoalPercentage
                    averages.get(12), // averageFreeThrows
                    averages.get(13), // averageFreeThrowAttempts
                    averages.get(14), // averageFreeThrowPercentage
                    averages.get(15), // averageOffensiveRebounds
                    averages.get(16), // averageDefensiveRebounds
                    averages.get(17), // averageTotalRebounds
                    averages.get(18), // averageAssists
                    averages.get(19), // averageSteals
                    averages.get(20), // averageBlocks
                    averages.get(21), // averageTurnovers
                    averages.get(22), // averagePersonalFouls
                    averages.get(23) // averagePoints
            );
        }

        return playersMap;
    }

    private HashMap<String, Team> getTeams() throws IOException {
        HashMap<String, List<PlayerSeasonBean>> teamsMap = findTeams();
        HashMap<String, Team> teams = new HashMap<>();

        for (Map.Entry<String, List<PlayerSeasonBean>> entry : teamsMap.entrySet()) {
            String key = entry.getKey();
            List<PlayerSeasonBean> players = entry.getValue();

            List<Double> averages = computeAverages(players);
            String[] keyParts = key.split("-");
            // Assuming the averages are in the same order as Team constructor parameters,
            // excluding name and season
            Team team = new Team(
                    keyParts[0],
                    keyParts[1],
                    averages.get(0), // averageAge
                    averages.get(1), // averageMinutesPlayed
                    averages.get(2), // averageFieldGoals
                    averages.get(3), // averageFieldGoalAttempts
                    averages.get(4), // averageFieldGoalPercentage
                    averages.get(5), // averageThreePointFieldGoals
                    averages.get(6), // averageThreePointFieldGoalAttempts
                    averages.get(7), // averageThreePointFieldGoalPercentage
                    averages.get(8), // averageTwoPointFieldGoals
                    averages.get(9), // averageTwoPointFieldGoalAttempts
                    averages.get(10), // averageTwoPointFieldGoalPercentage
                    averages.get(11), // averageEffectiveFieldGoalPercentage
                    averages.get(12), // averageFreeThrows
                    averages.get(13), // averageFreeThrowAttempts
                    averages.get(14), // averageFreeThrowPercentage
                    averages.get(15), // averageOffensiveRebounds
                    averages.get(16), // averageDefensiveRebounds
                    averages.get(17), // averageTotalRebounds
                    averages.get(18), // averageAssists
                    averages.get(19), // averageSteals
                    averages.get(20), // averageBlocks
                    averages.get(21), // averageTurnovers
                    averages.get(22), // averagePersonalFouls
                    averages.get(23) // averagePoints
            );

            teams.put(key, team);
        }

        return teams;
    }

    private HashMap<String, List<PlayerSeasonBean>> findTeams() throws IOException {
        List<PlayerSeasonBean> playerSeasons = readCsv();
        HashMap<String, List<PlayerSeasonBean>> teamsMap = new HashMap<>();

        for (PlayerSeasonBean season : playerSeasons) {
            String teamSeasonKey = season.getTeam() + "-" + season.getSeason();

            if (!teamsMap.containsKey(teamSeasonKey)) {
                teamsMap.put(teamSeasonKey, new ArrayList<>());
            }

            teamsMap.get(teamSeasonKey).add(season);
        }

        return teamsMap;
    }

    private List<Double> computeAverages(List<PlayerSeasonBean> players) {
        // Initialize variables to compute sums of each statistic
        double totalAge = 0;
        double totalMinutesPlayed = 0;
        double totalFieldGoals = 0;
        double totalFieldGoalAttempts = 0;
        double totalFieldGoalPercentage = 0;
        double totalThreePointFieldGoals = 0;
        double totalThreePointFieldGoalAttempts = 0;
        double totalThreePointFieldGoalPercentage = 0;
        double totalTwoPointFieldGoals = 0;
        double totalTwoPointFieldGoalAttempts = 0;
        double totalTwoPointFieldGoalPercentage = 0;
        double totalEffectiveFieldGoalPercentage = 0;
        double totalFreeThrows = 0;
        double totalFreeThrowAttempts = 0;
        double totalFreeThrowPercentage = 0;
        double totalOffensiveRebounds = 0;
        double totalTotalRebounds = 0;
        double totalDefensiveRebounds = 0;
        double totalAssists = 0;
        double totalSteals = 0;
        double totalBlocks = 0;
        double totalTurnovers = 0;
        double totalPersonalFouls = 0;
        double totalPoints = 0;

        for (PlayerSeasonBean player : players) {
            totalAge = player.getAge();
            totalMinutesPlayed = player.getMinutesPlayed();
            totalFieldGoals = player.getFieldGoals();
            totalFieldGoalAttempts = player.getFieldGoalAttempts();
            totalFieldGoalPercentage = player.getFieldGoalPercentage();
            totalThreePointFieldGoals = player.getThreePointFieldGoals();
            totalThreePointFieldGoalAttempts = player.getThreePointFieldGoalAttempts();
            totalThreePointFieldGoalPercentage = player.getThreePointFieldGoalPercentage();
            totalTwoPointFieldGoals = player.getTwoPointFieldGoals();
            totalTwoPointFieldGoalAttempts = player.getTwoPointFieldGoalAttempts();
            totalTwoPointFieldGoalPercentage = player.getTwoPointFieldGoalPercentage();
            totalEffectiveFieldGoalPercentage = player.getEffectiveFieldGoalPercentage();
            totalFreeThrows = player.getFreeThrows();
            totalFreeThrowAttempts = player.getFreeThrowAttempts();
            totalFreeThrowPercentage = player.getFreeThrowPercentage();
            totalOffensiveRebounds = player.getOffensiveRebounds();
            totalDefensiveRebounds = player.getDefensiveRebounds();
            totalTotalRebounds = player.getTotalRebounds();
            totalAssists = player.getAssists();
            totalSteals = player.getSteals();
            totalBlocks = player.getBlocks();
            totalTurnovers = player.getTurnovers();
            totalPersonalFouls = player.getPersonalFouls();
            totalPoints = player.getPoints();
        }

        int numberOfPlayers = players.size();
        List<Double> averages = new ArrayList<>();

        averages.add(totalAge / numberOfPlayers);
        averages.add(totalMinutesPlayed / numberOfPlayers);
        averages.add(totalFieldGoals / numberOfPlayers);
        averages.add(totalFieldGoalAttempts / numberOfPlayers);
        averages.add(totalFieldGoalPercentage / numberOfPlayers);
        averages.add(totalThreePointFieldGoals / numberOfPlayers);
        averages.add(totalThreePointFieldGoalAttempts / numberOfPlayers);
        averages.add(totalThreePointFieldGoalPercentage / numberOfPlayers);
        averages.add(totalTwoPointFieldGoals / numberOfPlayers);
        averages.add(totalTwoPointFieldGoalAttempts / numberOfPlayers);
        averages.add(totalTwoPointFieldGoalPercentage / numberOfPlayers);
        averages.add(totalEffectiveFieldGoalPercentage / numberOfPlayers);
        averages.add(totalFreeThrows / numberOfPlayers);
        averages.add(totalFreeThrowAttempts / numberOfPlayers);
        averages.add(totalFreeThrowPercentage / numberOfPlayers);
        averages.add(totalOffensiveRebounds / numberOfPlayers);
        averages.add(totalDefensiveRebounds / numberOfPlayers);
        averages.add(totalTotalRebounds / numberOfPlayers);
        averages.add(totalAssists / numberOfPlayers);
        averages.add(totalSteals / numberOfPlayers);
        averages.add(totalBlocks / numberOfPlayers);
        averages.add(totalTurnovers / numberOfPlayers);
        averages.add(totalPersonalFouls / numberOfPlayers);
        averages.add(totalPoints / numberOfPlayers);

        return averages;
    }

    public List<PlayerSeasonBean> readCsv() {
        List<PlayerSeasonBean> playerSeasonBeans = new ArrayList<>();
        String filePath = "stats.csv";

        try (Scanner scanner = new Scanner(new File(filePath))) {
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // Skip header line
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                // Assuming values are correctly ordered and formatted
                PlayerSeasonBean season = new PlayerSeasonBean(
                        values[1], // Player
                        values[2], // Position
                        Integer.parseInt(values[3]), // Age
                        values[4], // Team
                        Integer.parseInt(values[5]), // Games
                        Integer.parseInt(values[6]), // Games Started
                        Double.parseDouble(values[7]), // Minutes Played
                        Double.parseDouble(values[8]), // Field Goals
                        Double.parseDouble(values[9]), // Field Goal Attempts
                        Double.parseDouble(values[10]), // Field Goal Percentage
                        Double.parseDouble(values[11]), // Three Point Field Goals
                        Double.parseDouble(values[12]), // Three Point Field Goal Attempts
                        Double.parseDouble(values[13]), // Three Point Field Goal Percentage
                        Double.parseDouble(values[14]), // Two Point Field Goals
                        Double.parseDouble(values[15]), // Two Point Field Goal Attempts
                        Double.parseDouble(values[16]), // Two Point Field Goal Percentage
                        Double.parseDouble(values[17]), // Effective Field Goal Percentage
                        Double.parseDouble(values[18]), // Free Throws
                        Double.parseDouble(values[19]), // Free Throw Attempts
                        Double.parseDouble(values[20]), // Free Throw Percentage
                        Double.parseDouble(values[21]), // Offensive Rebounds
                        Double.parseDouble(values[22]), // Defensive Rebounds
                        Double.parseDouble(values[23]), // Total Rebounds
                        Double.parseDouble(values[24]), // Assists
                        Double.parseDouble(values[25]), // Steals
                        Double.parseDouble(values[26]), // Blocks
                        Double.parseDouble(values[27]), // Turnovers
                        Double.parseDouble(values[28]), // Personal Fouls
                        Double.parseDouble(values[29]), // Points
                        values[30], // Season
                        Boolean.parseBoolean(values[31]) // MVP
                );

                playerSeasonBeans.add(season);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }

        return playerSeasonBeans;
    }

    public HashMap<String, Player> getAveragePlayers() {
        return this.allPlayers;
    }

    public HashMap<String, Team> getTeamSeasons() {
        return this.allTeams;
    }

    public void printPlayers() {
        for (String name : allPlayers.keySet()) {
            String key = name.toString();
            String value = allPlayers.get(name).toString();
            System.out.println(key + " " + value);
        }
    }

}
