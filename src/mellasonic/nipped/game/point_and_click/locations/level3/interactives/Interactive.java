package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

import javafx.scene.image.Image;
import mellasonic.nipped.interactable.Rectangle;

public abstract class Interactive extends Rectangle {
    /**
     * whether or not this object can be clicked
     */
    private boolean enabled;
    /**
     * the image when this object is disabled
     */
    private final Image disabled;

    /**
     * Class constructor
     *
     * @param normal  the normal image
     * @param onHover the image to display when the cursor is hovered
     * @param disabled the image when this interactive is disabled
     * @param x       x of bounding box
     * @param y       y of bounding box
     * @param width   width of bounding box
     * @param height  height of bounding box
     */
    public Interactive(Image normal, Image onHover, Image disabled, int x, int y, int width, int height) {
        super(normal, onHover, x, y, width, height);
        enabled = true;
        this.disabled = disabled;
    }

    @Override
    public void onClick(){
        enabled = false;
        setNormal(disabled);
        setOnHover(disabled);
        onConsume();
    }

    /**
     * called when this object is consumed
     */
    public abstract void onConsume();

    @Override
    public boolean hit(double x, double y){
        if(enabled) return super.hit(x, y);
        else return false;
    }
}
