package mellasonic.nipped.game.point_and_click.interactives;

import javafx.scene.image.Image;
import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Rectangle;

public abstract class Food extends Rectangle {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;

    /**
     * Class constructor
     *
     * @param x       x of bounding box of the food
     * @param y       y of bounding box of the food
     */
    public Food(int x, int y) {
        super(Tools.getImage("assets/catfood.png"), Tools.getImage("assets/catfood.png"), x, y, WIDTH, HEIGHT);
    }
}
