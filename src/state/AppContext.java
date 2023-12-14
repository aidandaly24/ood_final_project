package src.state;

public class AppContext {
    private State currentState;

    public AppContext(String input) {
        // Setting initial state off user input
        if ("fetch".equalsIgnoreCase(input)) {
            currentState = new FetchingYearsState(); 
            this.handleInput();
        }

        if ("compare".equalsIgnoreCase(input)) {
            currentState = new PerformingComparisonState();
            this.handleInput();
        }
        
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getState() {
        return this.currentState;
    }

    public void handleInput(String input) {
        currentState.handleInput(this, input);
    }

    public void handleInput() {
        currentState.handleInput(this, input);
    }

    public void handleInput(int[] input) {
        currentState.handleInput(this, input);
    }
}
