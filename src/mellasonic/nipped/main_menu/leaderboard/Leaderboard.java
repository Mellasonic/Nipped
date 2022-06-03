package mellasonic.nipped.main_menu.leaderboard;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import mellasonic.nipped.AppState;

import java.util.List;

public class Leaderboard implements AppState {
    /**
     * the current scene
     */
    private final Scene screen;

    public Leaderboard(){
        Pane cur = new Pane();
        List<Score> scores = ScoreReader.getScores();

        screen = new Scene(cur);
    }

    @Override
    public Scene getScene() {
        return screen;
    }
}
