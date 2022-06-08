package mellasonic.nipped.game.point_and_click.locations.level1;

import javafx.scene.image.Image;
import mellasonic.nipped.interactable.Rectangle;

/**
 * a consumable in level 1
 */
public abstract class Consumable extends Rectangle {
    /**
     * whether or not the food has already been clicked
     */
    private boolean enabled;
    /**
     * the image when disabled
     */
    private final Image disabledImage;

    /**
     * Class constructor
     *
     * @param normal  the normal image
     * @param onHover the image to display when the cursor is hovered
     * @param disabled the image for when the consumable is disabled
     * @param x       x of bounding box
     * @param y       y of bounding box
     * @param width   width of bounding box
     * @param height  height of bounding box
     */
    public Consumable(Image normal, Image onHover, Image disabled, int x, int y, int width, int height) {
        super(normal, onHover, x, y, width, height);
        this.disabledImage = disabled;
        enabled = true;
    }

    /**
     * disables the food (usually after it's been clicked)
     */
    public void disable(){
        enabled = false;
        setNormal(disabledImage);
        setOnHover(disabledImage);
    }

    @Override
    public boolean hit(double x, double y){
        if(enabled) return super.hit(x, y);
        else return false;
    }
}
