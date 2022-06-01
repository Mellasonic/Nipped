package mellasonic.nipped.game.point_and_click.locations.level1;

import javafx.scene.image.Image;
import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Rectangle;

public abstract class Note extends Consumable {
    /**
     * Dimensions of the note
     */
    public static final int WIDTH=21, HEIGHT=30;

    /**
     * Class constructor
     *
     * @param x       x of bounding box
     * @param y       y of bounding box
     */
    public Note(int x, int y) {
        super(Tools.getImage("assets/note.png"), Tools.getImage("assets/note.png"),
                Tools.getImage("assets/note.png"), x, y, WIDTH, HEIGHT);
    }
}
