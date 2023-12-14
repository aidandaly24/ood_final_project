package src.factory;

public class ComparisonFactory {

    public enum ComparisonType {
        PLAYER, TEAM
    }

    public Comparison getComparison(ComparisonType type) {
        switch (type) {
            case PLAYER:
                return new PlayerComparison();
            case TEAM:
                return new TeamComparison();
            default:
                throw new IllegalArgumentException("Unknown comparison type: " + type);
        }
    }
}
