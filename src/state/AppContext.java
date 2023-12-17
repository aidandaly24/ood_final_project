package src.state;

public class AppContext {
    private State currentState;

    public AppContext(String input) {
        if ("compare".equalsIgnoreCase(input)) {
            currentState = new PerformingComparisonState();
            this.handleInput();
        } else if ("quit".equalsIgnoreCase(input)) {
            currentState = new QuittingState();
            this.handleInput();
        } else {
            System.out.println("\n That was not a correct input, please enter eiter 'compare' or 'quit'.");
            currentState = new ReadyForComparisonState();
        }

    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getState() {
        return this.currentState;
    }

    public void handleInput() {
        currentState.handleInput(this);
    }

}
