/* ICS Final Project Nipped
 2022/06/06
 Time spent: 40 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 7 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Eric Jin, James Huynh
 Version 1.1
 2022/06/06
 Time spent: 40 min
 New features/processing: create note overlay, overlay text
*/

package mellasonic.nipped.game.point_and_click.locations.level3.overlays;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;

public class NoteOverlay extends Overlay{
    /**
     * dimensions of the note overlay
     */
    public static final int WIDTH=210, HEIGHT=300;
    /**
     * the margins of the text
     */
    public static final int MARGIN = 15, TOP_MARGIN=50;

    /**
     * class constructor
     *
     * @param prev    the previous location
     * @param changer the screen changer
     * @param message the message of the note
     */
    public NoteOverlay(Location prev, ScreenChanger changer, String message) {
        super(prev, changer);

        // create the overlay
        Pane overlay = new Pane();
        overlay.setLayoutX(0);
        overlay.setLayoutY(0);
        overlay.setPrefSize(Main.WIDTH, Main.HEIGHT);

        // the note
        ImageView view = new ImageView(Tools.getImage("assets/note.png"));
        view.setFitWidth(WIDTH);
        view.setFitHeight(HEIGHT);
        view.setLayoutX(Main.WIDTH / 2.0 - WIDTH / 2.0);
        view.setLayoutY(Main.HEIGHT / 2.0 - WIDTH / 2.0);
        overlay.getChildren().add(view);

        // the displayed text
        Text display = new Text(message);
        display.setLayoutX(view.getLayoutX() + MARGIN);
        display.setLayoutY(view.getLayoutY() + TOP_MARGIN);
        display.setWrappingWidth(view.getFitWidth() - 2 * MARGIN);
        display.setFont(new Font("MV Boli", 18));
        overlay.getChildren().add(display);

        overlay.setOnMouseClicked(me -> changeBack());
        overlay.setOnMouseClicked(me -> changeBack());

        addNode(overlay);
    }
}
