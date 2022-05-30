package mellasonic.nipped.game.point_and_click.interactives;

import javafx.scene.image.Image;
import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Collider;
import mellasonic.nipped.interactable.Rectangle;

public abstract class Invisible extends Rectangle {
    /**
     * Class constructor
     *
     * @param x       x of bounding box
     * @param y       y of bounding box
     * @param width   width of bounding box
     * @param height  height of bounding box
     */
    public Invisible(int x, int y, int width, int height) {
        super(Tools.getImage("assets/invisible.png"), Tools.getImage("assets/invisible.png"), x, y, width, height);
    }
}
