package src.factory;

public class TeamComparison implements Comparison {
    @Override
    public String compare(String team1, String team2) {
        // Implement team comparison logic here
        return "Team comparison result between " + team1 + " and " + team2;
    }
}
