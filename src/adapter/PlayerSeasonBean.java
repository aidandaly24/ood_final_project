package src.adapter;

// G,GS,MP,FG,FGA,FG%,3P,3PA,3P%,2P,2PA,2P%,eFG%,FT,FTA,FT%,ORB,DRB,TRB,AST,STL,BLK,TOV,PF,PTS,Season,MVP
// 31,0,17.1,3.3,8.8,.377,0.2,1.0,.161,3.2,7.8,.405,.386,0.5,0.5,1.000,0.2,1.0,1.2,1.9,0.5,0.0,0.6,1.0,7.3,1997-98,False

public class PlayerSeasonBean {
    private String player;
    private String position;
    private int age;
    private String team;
    private int games;
    private int gamesStarted;
    private double minutesPlayed;
    private double fieldGoals;
    private double fieldGoalAttempts;
    private double fieldGoalPercentage;
    private double threePointFieldGoals;
    private double threePointFieldGoalAttempts;
    private double threePointFieldGoalPercentage;
    private double twoPointFieldGoals;
    private double twoPointFieldGoalAttempts;
    private double twoPointFieldGoalPercentage;
    private double effectiveFieldGoalPercentage;
    private double freeThrows;
    private double freeThrowAttempts;
    private double freeThrowPercentage;
    private double offensiveRebounds;
    private double defensiveRebounds;
    private double totalRebounds;
    private double assists;
    private double steals;
    private double blocks;
    private double turnovers;
    private double personalFouls;
    private double points;
    private String season;
    private boolean mvp;

    public PlayerSeasonBean(String player, String position, int age, String team,
            int games, int gamesStarted, double minutesPlayed,
            double fieldGoals, double fieldGoalAttempts, double fieldGoalPercentage,
            double threePointFieldGoals, double threePointFieldGoalAttempts, double threePointFieldGoalPercentage,
            double twoPointFieldGoals, double twoPointFieldGoalAttempts, double twoPointFieldGoalPercentage,
            double effectiveFieldGoalPercentage, double freeThrows, double freeThrowAttempts,
            double freeThrowPercentage,
            double offensiveRebounds, double defensiveRebounds, double totalRebounds,
            double assists, double steals, double blocks,
            double turnovers, double personalFouls, double points,
            String season, boolean mvp) {
        this.player = player;
        this.position = position;
        this.age = age;
        this.team = team;
        this.games = games;
        this.gamesStarted = gamesStarted;
        this.minutesPlayed = minutesPlayed;
        this.fieldGoals = fieldGoals;
        this.fieldGoalAttempts = fieldGoalAttempts;
        this.fieldGoalPercentage = fieldGoalPercentage;
        this.threePointFieldGoals = threePointFieldGoals;
        this.threePointFieldGoalAttempts = threePointFieldGoalAttempts;
        this.threePointFieldGoalPercentage = threePointFieldGoalPercentage;
        this.twoPointFieldGoals = twoPointFieldGoals;
        this.twoPointFieldGoalAttempts = twoPointFieldGoalAttempts;
        this.twoPointFieldGoalPercentage = twoPointFieldGoalPercentage;
        this.effectiveFieldGoalPercentage = effectiveFieldGoalPercentage;
        this.freeThrows = freeThrows;
        this.freeThrowAttempts = freeThrowAttempts;
        this.freeThrowPercentage = freeThrowPercentage;
        this.offensiveRebounds = offensiveRebounds;
        this.defensiveRebounds = defensiveRebounds;
        this.totalRebounds = totalRebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.turnovers = turnovers;
        this.personalFouls = personalFouls;
        this.points = points;
        this.season = season;
        this.mvp = mvp;
    }

    public String getPlayer() {
        return player;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    public int getGames() {
        return games;
    }

    public int getGamesStarted() {
        return gamesStarted;
    }

    public double getMinutesPlayed() {
        return minutesPlayed;
    }

    public double getFieldGoals() {
        return fieldGoals;
    }

    public double getFieldGoalAttempts() {
        return fieldGoalAttempts;
    }

    public double getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }

    public double getThreePointFieldGoals() {
        return threePointFieldGoals;
    }

    public double getThreePointFieldGoalAttempts() {
        return threePointFieldGoalAttempts;
    }

    public double getThreePointFieldGoalPercentage() {
        return threePointFieldGoalPercentage;
    }

    public double getTwoPointFieldGoals() {
        return twoPointFieldGoals;
    }

    public double getTwoPointFieldGoalAttempts() {
        return twoPointFieldGoalAttempts;
    }

    public double getTwoPointFieldGoalPercentage() {
        return twoPointFieldGoalPercentage;
    }

    public double getEffectiveFieldGoalPercentage() {
        return effectiveFieldGoalPercentage;
    }

    public double getFreeThrows() {
        return freeThrows;
    }

    public double getFreeThrowAttempts() {
        return freeThrowAttempts;
    }

    public double getFreeThrowPercentage() {
        return freeThrowPercentage;
    }

    public double getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public double getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public double getTotalRebounds() {
        return totalRebounds;
    }

    public double getAssists() {
        return assists;
    }

    public double getSteals() {
        return steals;
    }

    public double getBlocks() {
        return blocks;
    }

    public double getTurnovers() {
        return turnovers;
    }

    public double getPersonalFouls() {
        return personalFouls;
    }

    public double getPoints() {
        return points;
    }

    public String getSeason() {
        return season;
    }

    public boolean getMvp() {
        return mvp;
    }

    @Override
    public String toString() {
        return this.player;
    }

}
