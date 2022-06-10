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
 New features/processing: Create Quit Screen, add click functionality
*/

package mellasonic.nipped.main_menu;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mellasonic.nipped.AppState;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A screen that is displayed when the user quits
 */
public class QuitScreen implements AppState {
    /**
     * the screen
     */
    private final Scene screen;

    /**
     * class constructor
     */
    public QuitScreen(){
        // create the background
        ImageView bg = new ImageView(Tools.getImage("assets/goodbyescreen.png"));
        Tools.setPos(bg, 0, 0);
        bg.setFitWidth(Main.WIDTH);
        bg.setFitHeight(Main.HEIGHT);

        // prompt the user to exit
        Text text = Tools.createText("Created by: Eric Jin, James Huynh, Daniel Ye\n<Click anywhere to exit>", TextAlignment.CENTER, new Font("Bell MT", 32),
                0, Main.HEIGHT - 125, Main.WIDTH);
        text.setStroke(new Color(1, 1, 1, 1));
        text.setFill(new Color(1, 1, 1, 1));

        Group container = new Group(bg, text);

        // on click, exit
        container.setOnMouseClicked(me -> Main.getApp().exit());

        screen = new Scene(container);
    }

    @Override
    public Scene getScene() {
        return screen;
    }
}
