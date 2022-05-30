package mellasonic.nipped.game.point_and_click.interactives;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mellasonic.nipped.Tools;
import mellasonic.nipped.interactable.Collider;
import mellasonic.nipped.interactable.Interactive;
import mellasonic.nipped.interactable.Rectangle;

/**
 * an invisible collider
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
        ImageView bg = new ImageView(Tools.getImage("assets/invisible.png"));
        bg.setFitWidth(width);
        bg.setFitHeight(height);
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

    public Node getNode(){
        return cur;
    }
}
