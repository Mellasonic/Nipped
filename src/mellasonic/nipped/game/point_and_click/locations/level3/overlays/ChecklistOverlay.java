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
 New features/processing: create checklist overlay
*/

package mellasonic.nipped.game.point_and_click.locations.level3.overlays;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * an overlay for adding a checklist
 */
public class ChecklistOverlay extends Overlay {
    /**
     * dimensions of the checklist overlay
     */
    public static final int WIDTH=70, HEIGHT=100;

    /**
     * class constructor
     * @param prev the previous location
     * @param changer the screen changer
     */
    public ChecklistOverlay(Location prev, ScreenChanger changer){
        super(prev, changer);
        // create the overlay & position it
        Pane overlay = new Pane();
        Tools.setPos(overlay, 0, 0);
        overlay.setPrefSize(Main.WIDTH, Main.HEIGHT);

        // the clickable notepad
        ImageView click = new ImageView(Tools.getImage("assets/note.png"));
        Tools.setPos(click, Main.WIDTH / 2 - WIDTH / 2, Main.HEIGHT / 2 - HEIGHT / 2);
        click.setFitWidth(WIDTH);
        click.setFitHeight(HEIGHT);

        // add functionality to the notepad
        AtomicBoolean changed = new AtomicBoolean(false);
        overlay.setOnMouseClicked(me -> {
            // if we already changed the notepad, go to the previous screen
            if(changed.get()){
                changeBack();
            } else {
                // add text to the notepad
                click.setImage(Tools.getImage("assets/checklistmain.png"));
                changed.set(true);
            }
        });
        overlay.getChildren().add(click);

        addNode(overlay);
    }
}
