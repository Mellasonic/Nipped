/*
 * Version 0.0.01
 * Daniel Ye, Eric Jin
 * Ms. Krasteva
 * May 17, 2022
 * Rectangle Collider
 * 30 mins
 * Daniel Ye: Create rectangle logic
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
