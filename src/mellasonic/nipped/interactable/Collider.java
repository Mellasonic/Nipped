/*
 * Version 0.0.01
 * Daniel Ye, Eric Jin
 * Ms. Krasteva
 * May 17, 2022
 * 1 hour
 * Daniel Ye: Created Collider collision detection & node return
 */

package mellasonic.nipped.interactable;

// imports
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The default interactive type for point and click games
 */
public abstract class Collider implements Interactive{
    /**
     * The image to normally display
     */
    private final Image normal;
    /**
     * The image to display when the cursor is hovered over the sprite
     */
    private final Image onHover;
    /**
     * the bounding box of the image
     */
    protected final int x, y, width, height;

    /**
     * Class constructor
     * @param normal the normal image
     * @param onHover the image to display when the cursor is hovered
     * @param x x of bounding box
     * @param y y of bounding box
     * @param width width of bounding box
     * @param height height of bounding box
     */
    public Collider(Image normal, Image onHover, int x, int y, int width, int height){
        this.normal = normal;
        this.onHover = onHover;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * @param x x coordinate relative to bounding box
     * @param y y coordinate relative to bounding box
     * @return whether or not the cursor is considered to be within the "interactive range" of the object
     */
    protected abstract boolean hit(double x, double y);

    @Override
    public Node getNode(){
        // create a bounded image of the collider
        ImageView view = new ImageView(normal);
        view.setFitWidth(width);
        view.setFitHeight(height);
        view.setLayoutX(x);
        view.setLayoutY(y);

        view.setOnMouseMoved(me -> {
            // change image to hover or normal depending on if the mouse is in the interactive range
            if(hit(me.getX(), me.getY())){
                view.setImage(onHover);
            } else {
                view.setImage(normal);
            }
        });

        // when the mouse exits the node, unhighlight it
        view.setOnMouseExited(me -> {
            view.setImage(normal);
        });

        view.setOnMouseClicked(me -> {
            // perform the onClick function when the node is considered to be "clicked"
            if(hit(me.getX(), me.getY())){
                onClick();
            }
        });

        return view;
    }
}
