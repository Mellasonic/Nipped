package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

import javafx.scene.image.Image;
import mellasonic.nipped.Tools;

public abstract class CatClean extends Interactive{
    /**
     * Dimensions of the icon
     */
    public static int WIDTH=70, HEIGHT=90;

    /**
     * Class constructor
     *
     * @param x        x of bounding box
     * @param y        y of bounding box
     */
    public CatClean(int x, int y) {
        super(Tools.getImage("assets/broom.png"), Tools.getImage("assets/broom.png"),
                Tools.getImage("assets/sweepcat.gif"), x, y, WIDTH, HEIGHT);
    }
}
