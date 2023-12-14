package src.factory;

public class PlayerComparison implements Comparison {
    @Override
    public String compare(String player1, String player2) {
        // Implement player comparison logic here
        return "Player comparison result between " + player1 + " and " + player2;
    }
}
