/* ICS Final Project Nipped
 2022/06/07
 Time spent: 30 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 07 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Eric Jin, Daniel Ye
 Version 1.1
 2022/06/07
 Time spent: 30 min
 New features/processing: create winscreen
*/

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
