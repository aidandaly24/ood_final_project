package src.state;

public class QuittingState implements State {

    @Override
    public void handleInput(AppContext context) {
        System.out.println(
                "Hope you had a good time with my program. Come back soon and all files will be here unless you delete the folder from your computer.");

    }

}
