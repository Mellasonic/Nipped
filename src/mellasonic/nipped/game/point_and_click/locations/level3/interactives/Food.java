package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

import javafx.scene.image.Image;
import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Rectangle;

public abstract class Food extends Interactive {
    /**
     * Dimensions of this food
     */
    public static int WIDTH=40, HEIGHT=30;

    /**
     * Class constructor
     *
     * @param x       x of bounding box
     * @param y       y of bounding box
     */
    public Food(int x, int y) {
        super(Tools.getImage("assets/burger.png"), Tools.getImage("assets/burger.png"),
                Tools.getImage("assets/apple.png"), x, y, WIDTH, HEIGHT);
    }
}
