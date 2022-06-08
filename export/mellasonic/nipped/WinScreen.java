package mellasonic.nipped;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import mellasonic.nipped.game.ScoreState;

/**
 * a win screen
 */
public class WinScreen implements AppState{
    /**
     * the screen
     */
    private final Scene screen;

    public WinScreen(int score){
        ImageView bg = Tools.makeSprite("assets/winscreen.png", Main.WIDTH, Main.HEIGHT);
        bg.setOnMouseClicked(me -> Main.getApp().changeState(new ScoreState(score)));
        screen = new Scene(new Group(bg));
    }

    @Override
    public Scene getScene() {
        return screen;
    }
}
