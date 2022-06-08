/* ICS Final Project Nipped
 2022/06/06
 Time spent: 30 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 7 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye, Eric Jin
 Version 1.1
 2022/06/06
 Time spent: 30 min
 New features/processing: create diary overlay
*/

package mellasonic.nipped.game.point_and_click.locations.level3.overlays;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;

import java.util.concurrent.atomic.AtomicBoolean;

public class DiaryOverlay extends Overlay{
    /**
     * dimensions of the diary
     */
    public static int WIDTH=360, HEIGHT=300;

    /**
     * class constructor
     *
     * @param prev    the previous location
     * @param changer the screen changer
     */
    public DiaryOverlay(Location prev, ScreenChanger changer) {
        super(prev, changer);

        // create the overlay
        Pane overlay = new Pane();
        overlay.setLayoutX(0);
        overlay.setLayoutY(0);
        overlay.setPrefSize(Main.WIDTH, Main.HEIGHT);

        // the foreground image
        ImageView view = new ImageView(Tools.getImage("assets/unfdiary.png"));
        view.setLayoutX(Main.WIDTH / 2.0 - WIDTH / 2.0);
        view.setLayoutY(Main.HEIGHT / 2.0 - HEIGHT / 2.0);
        view.setFitWidth(WIDTH);
        view.setFitHeight(HEIGHT);

        // a constant reference to a boolean
        AtomicBoolean changed = new AtomicBoolean(false);

        // fill the diary then return
        view.setOnMouseClicked(me -> {
            if(changed.get()){
                changeBack();
            } else {
                view.setImage(Tools.getImage("assets/unfdiaryfilled.png"));
                changed.set(true);
            }
        });

        overlay.getChildren().add(view);
        addNode(overlay);
    }
}
