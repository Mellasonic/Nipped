/* ICS Final Project Nipped
 2022/06/10
 Time spent: 1 hour 40 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.2 - 10 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: James Huynh
 Version 1.1
 2022/05/31
 Time spent: 40 min
 New features/processing: Create Collider, add star, position rectangle, create assets
*/

/*
 Modification Authors: Eric Jin
 Version 1.2
 2022/06/10
 Time spent: 1 hour
 New features/processing: Refactor code, create setHasStar, allow for dynamic changing of the star
*/

package mellasonic.nipped.game.point_and_click.interactives;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import mellasonic.nipped.Main;
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
     * whether or not there is a star in the collider
     */
    private boolean hasStar;
    /**
     * the star that will be added or removed
     */
    private final ImageView star;

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

        // initialize the star
        star = new ImageView(Tools.getImage("assets/sparkles.png"));
        star.setFitWidth(STAR_WIDTH);
        star.setFitHeight(STAR_HEIGHT);
        star.setLayoutX(width - STAR_WIDTH);
        star.setLayoutY(0);
        this.hasStar = false;
        setHasStar(hasStar);

        // add the background of the box
        Rectangle bg = new Rectangle(width, height);
        bg.setFill(new Color(1, 1, 0, 0));
        bg.setStrokeType(StrokeType.CENTERED);
        bg.setStroke(new Color(1, 1, 0, 0));
        bg.setStrokeWidth(1);
        cur.getChildren().add(bg);

        // handle click
        cur.setOnMouseClicked(me -> {
            setHasStar(false);
            onClick();
        });

        cur.setOnMouseEntered(me -> Main.getApp().setCursor(Cursor.HAND));
        cur.setOnMouseExited(me -> Main.getApp().setCursor(Cursor.DEFAULT));
    }

    /**
     * sets whether or not there is a star sprite in the collider
     * @param hasStar whether or not the add the star sprite
     */
    public void setHasStar(boolean hasStar){
        if(this.hasStar != hasStar){
            if(!hasStar){
                cur.getChildren().remove(star);
            } else {
                cur.getChildren().add(star);
            }
            this.hasStar = hasStar;
        }
    }

    @Override
    public Node getNode(){
        return cur;
    }
}
