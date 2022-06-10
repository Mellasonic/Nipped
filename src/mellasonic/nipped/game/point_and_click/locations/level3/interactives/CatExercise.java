/* ICS Final Project Nipped
 2022/06/06
 Time spent: 30 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 6 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: James Huynh, Eric Jin
 Version 1.1
 2022/06/06
 Time spent: 30 min
 New features/processing: create cat exercise sprite, change screen
*/

package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.interactives.Invisible;
import mellasonic.nipped.interactable.Collider;
import mellasonic.nipped.interactable.Interactive;
import mellasonic.nipped.interactable.Rectangle;

/**
 * The sprite for a cat exercising
 */
public abstract class CatExercise implements Interactive {
    /**
     * the pane
     */
    private final Pane node;
    /**
     * dimensions of the jumping cat
     */
    public static final int WIDTH=60, HEIGHT=50;


    /**
     * Class Constructor
     *
     * @param x the x value of the sprite
     * @param y the y value of the sprite
     * @param width the width of the sprite
     * @param height the height of the sprite
     */
    public CatExercise(int x, int y, int width, int height){
        // an instance to this
        CatExercise instance = this;

        // create the node with an invisible collider
        node = new Pane(new Invisible(0, 0, width, height, false){
            @Override
            public void onClick() {
                // remove the invisible collider, add the jumpcat image
                instance.onClick();
                node.getChildren().clear();
                node.getChildren().add(
                        Tools.makeSprite("assets/exercisingcat.gif", width / 2 - WIDTH / 2,
                                190 - HEIGHT, WIDTH, HEIGHT)
                );
            }
        }.getNode());

        // sets the position and size of the node
        node.setLayoutX(x);
        node.setLayoutY(y);
        node.setPrefSize(width, height);
    }

    @Override
    public Node getNode() {
        return node;
    }
}
