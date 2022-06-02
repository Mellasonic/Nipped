package mellasonic.nipped.game.point_and_click.locations.level3;

import javafx.scene.image.Image;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.Screen;
import mellasonic.nipped.interactable.Rectangle;

/**
 * a note icon
 */
public abstract class Note extends Rectangle {
    /**
     * Dimensions of a note
     */
    public static final int WIDTH=60, HEIGHT=90;

    /**
     * Class constructor
     *
     * @param x       x of bounding box
     * @param y       y of bounding box
     */
    public Note(int x, int y) {
        super(Tools.getImage("assets/note.png"), Tools.getImage("assets/note.png"), x, y, WIDTH, HEIGHT);
    }
}
