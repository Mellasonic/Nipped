/* ICS Final Project Nipped
 2022/05/17
 Time spent: 30 mins
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
 Time spent: 30 mins
 New features/processing: Collider collision detection, override methods
*/

package mellasonic.nipped.interactable;

// imports

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mellasonic.nipped.Main;

/**
 * The default interactive type for point and click games
 */
public abstract class Collider implements Interactive{
    /**
     * The image to normally display
     */
    private Image normal;
    /**
     * The image to display when the cursor is hovered over the sprite
     */
    private Image onHover;
    /**
     * the bounding box of the image
     */
    protected final int x, y, width, height;
    /**
     * the current node
     */
    private final ImageView view;

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

        // create a bounded image of the collider
        view = new ImageView(normal);
        view.setFitWidth(width);
        view.setFitHeight(height);
        view.setLayoutX(x);
        view.setLayoutY(y);

        view.setOnMouseMoved(me -> {
            // change image to hover or normal depending on if the mouse is in the interactive range
            if(hit(me.getX(), me.getY())){
                view.setImage(this.onHover);
                Main.getApp().setCursor(Cursor.HAND);
            } else {
                view.setImage(this.normal);
            }
        });

        // when the mouse exits the node, unhighlight it
        view.setOnMouseExited(me -> {
            view.setImage(this.normal);
            Main.getApp().setCursor(Cursor.DEFAULT);
        });

        view.setOnMouseClicked(me -> {
            // perform the onClick function when the node is considered to be "clicked"
            if(hit(me.getX(), me.getY())){
                onClick();
            }
        });
    }

    /**
     * sets the normal image
     * @param normal the image to set it to
     */
    protected void setNormal(Image normal) {
        this.normal = normal;
        view.setImage(normal);
    }

    /**
     * sets the image on hover
     * @param onHover the image to set it to
     */
    protected void setOnHover(Image onHover) {
        this.onHover = onHover;
        view.setImage(normal);
    }

    /**
     * sets the dimensions
     * @param width the width
     * @param height the height
     */
    protected void setDimensions(int width, int height){
        this.view.setFitWidth(width);
        this.view.setFitHeight(height);
    }

    /**
     * sets the position
     * @param x the x coordinate
     * @param y the y coordinate
     */
    protected void setPosition(int x, int y){
        this.view.setLayoutX(x);
        this.view.setLayoutY(y);
    }

    /**
     * returns whether or not the cursor hits the collider
     * @param x x coordinate relative to bounding box
     * @param y y coordinate relative to bounding box
     * @return whether or not the cursor is considered to be within the "interactive range" of the object
     */
    protected abstract boolean hit(double x, double y);

    @Override
    public Node getNode(){
        return view;
    }
}
