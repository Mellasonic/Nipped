/* ICS Final Project Nipped
 2022/05/31
 Time spent: 40 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 31 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/31
 Time spent: 40 min
 New features/processing: Create Collider, add star, position rectangle, create assets
*/

package mellasonic.nipped.game.point_and_click.interactives;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Interactive;

/**
 * an invisible collider that is meant to symbolize an object in the background.
 * It contains a yellow tint and outline, and potentially a star for when it hasn't been clicked yet
 */
public abstract class Invisible implements Interactive {
    /**
     * Current node
     */
    private final Pane cur;
    /**
     * Dimensions of the star
     */
    public static final int STAR_WIDTH=20, STAR_HEIGHT=30;

    /**
     * Class constructor - will have a star by default
     *
     * @param x       x of bounding box
     * @param y       y of bounding box
     * @param width   width of bounding box
     * @param height  height of bounding box
     */
    public Invisible(int x, int y, int width, int height){
        this(x, y, width, height, true);
    }

    /**
     * Class constructor
     *
     * @param x       x of bounding box
     * @param y       y of bounding box
     * @param width   width of bounding box
     * @param height  height of bounding box
     * @param hasStar whether or not the bounding box should have a star
     */
    public Invisible(int x, int y, int width, int height, boolean hasStar) {
        // initialize the pane and set its size
        cur = new Pane();
        cur.setPrefSize(width, height);
        cur.setLayoutX(x);
        cur.setLayoutY(y);

        // add the background of the box
        Rectangle bg = new Rectangle(width, height);
        bg.setFill(new Color(1, 1, 0, 0.2));
        bg.setStrokeType(StrokeType.CENTERED);
        bg.setStroke(new Color(1, 1, 0, 1));
        bg.setStrokeWidth(1);
        cur.getChildren().add(bg);

        // add the star in the box
        ImageView star = new ImageView(Tools.getImage("assets/sparkles.png"));
        if(hasStar){
            star.setFitWidth(STAR_WIDTH);
            star.setFitHeight(STAR_HEIGHT);
            star.setLayoutX(width - STAR_WIDTH);
            star.setLayoutY(0);
            cur.getChildren().add(star);
        }

        // handle click
        cur.setOnMouseClicked(me -> {
            cur.getChildren().remove(star);
            onClick();
        });
    }

    @Override
    public Node getNode(){
        return cur;
    }
}
