/* ICS Final Project Nipped
 2022/06/02
 Time spent: 20 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.0 - 2 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Eric Jin
 Version 1.0
 2022/06/02
 Time spent: 20 min
 New features/processing: Create overlay, background and content
*/

package mellasonic.nipped.game.point_and_click.locations.level3;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.Screen;

/**
 * an overlay for when there a note
 */
public class NoteOverlay implements Screen {
    /**
     * the screen node
     */
    private Pane screen;

    /**
     * class constructor
     * @param prev the previous screen
     * @param message the message to display on the note
     */
    public NoteOverlay(Screen prev, String message){
        screen = new Pane();
        screen.setPrefSize(Main.WIDTH, Main.HEIGHT);
        screen.setLayoutY(0);
        screen.setLayoutX(0);

        ImageView bg = new ImageView(Tools.getImage("assets/notebg.png"));
        bg.setFitWidth(Main.WIDTH);
        bg.setFitHeight(Main.HEIGHT);
        bg.setLayoutY(0);
        bg.setLayoutX(0);
        screen.getChildren().add(bg);

        Text content = new Text(message);
        content.setLayoutX(100);
        content.setLayoutY(100);
    }

    @Override
    public Node getNode() {
        return screen;
    }
}
