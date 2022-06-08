/* ICS Final Project Nipped
 2022/05/17
 Time spent: 20 mins
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
 Time spent: 20 mins
 New features/processing: create button image, add hover animation & click functionality
*/

package mellasonic.nipped.interactable;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * A button used in the main menu
 */
public abstract class Button implements Interactive{

    /**
     * Compatible node to display
     */
    private final ImageView ret;

    /**
     * Class constructor
     * @param normal the image to normally display
     * @param onHover the image to display when the player hovers over it
     * @param width the width of the image
     * @param height the height of the image
     */
    public Button(Image normal, Image onHover, int width, int height){
        // initialize current node
        this.ret = new ImageView(normal);
        ret.setFitWidth(width);
        ret.setFitHeight(height);

        // set events to handle
        ret.setOnMouseEntered(me -> ret.setImage(onHover));
        ret.setOnMouseExited(me -> ret.setImage(normal));
        ret.setOnMouseClicked(me -> onClick());
    }

    @Override
    public Node getNode() {
        return ret;
    }
}
