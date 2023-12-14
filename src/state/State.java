package src.state;

public interface State {
    void handleInput(AppContext context, String input);
}
