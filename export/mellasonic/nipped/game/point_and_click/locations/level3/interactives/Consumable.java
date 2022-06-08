/* ICS Final Project Nipped
 2022/06/03
 Time spent: 20 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 3 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye, James Huynh
 Version 1.1
 2022/06/03
 Time spent: 20 min
 New features/processing: create interactive
*/

package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

import javafx.scene.image.Image;
import mellasonic.nipped.interactable.Rectangle;

public abstract class Consumable extends Rectangle {
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
    public Consumable(Image normal, Image onHover, Image disabled, int x, int y, int width, int height) {
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
