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
