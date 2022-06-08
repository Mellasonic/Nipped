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
 New features/processing: Create Quit Screen
*/

package mellasonic.nipped.main_menu;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import mellasonic.nipped.AppState;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;

import java.util.Timer;
import java.util.TimerTask;

public class QuitScreen implements AppState {
    /**
     * the screen
     */
    private final Scene screen;

    public QuitScreen(){
        // create the background
        ImageView bg = new ImageView(Tools.getImage("assets/goodbyescreen.png"));
        Tools.setPos(bg, 0, 0);
        bg.setFitWidth(Main.WIDTH);
        bg.setFitHeight(Main.HEIGHT);

        screen = new Scene(new Group(bg));

        // create a timer to exit the program
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Main.getApp().exit();
            }
        }, 5000);
    }

    @Override
    public Scene getScene() {
        return screen;
    }
}
