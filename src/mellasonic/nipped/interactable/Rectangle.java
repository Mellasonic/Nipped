/* ICS Final Project Nipped
 2022/05/17
 Time spent: 10 mins
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 17 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/17
 Time spent: 10 mins
 New features/processing: Created Rectangle, override logic
*/

package mellasonic.nipped.interactable;

// imports
import javafx.scene.image.Image;

/**
 * A rectangle Collider
 */
public abstract class Rectangle extends Collider{
    /**
     * Class constructor
     * @param normal the normal image
     * @param onHover the image to display when the cursor is hovered
     * @param x x of bounding box
     * @param y y of bounding box
     * @param width width of bounding box
     * @param height height of bounding box
     */
    public Rectangle(Image normal, Image onHover, int x, int y, int width, int height) {
        super(normal, onHover, x, y, width, height);
    }

    @Override
    public boolean hit(double x, double y) {
        return true;
    }
}
