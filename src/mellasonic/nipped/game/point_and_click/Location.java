package mellasonic.nipped.game.point_and_click;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mellasonic.nipped.Main;
import mellasonic.nipped.interactable.Interactive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A Location in the point and click game
 */
public abstract class Location implements Screen{

    /**
     * A list of interactive objects
     */
    private final List<Interactive> objects;
    /**
     * The image to display in the background
     */
    private final Image background;
    /**
     * The node of the location
     */
    private final Pane cur;

    /**
     * Class constructor
     * @param background the background of the image
     * @param interactive the list of interactive objects
     */
    public Location(Image background, List<Interactive> interactive){
        this.background = background;
        this.objects = interactive;

        // initialize the current node and draw elements onto it
        cur = new Pane();
        drawElements();
    }

    /**
     * Adds an interactive object
     * @param toAdd the interactive objects to add
     */
    public void addObjects(Collection<Interactive> toAdd){
        objects.addAll(toAdd);
        drawElements();
    }

    /**
     * Draws elements onto the pane
     */
    private void drawElements(){
        // clear the children
        cur.getChildren().clear();

        // draw the background onto the screen
        ImageView backgroundView = new ImageView(background);
        backgroundView.setFitWidth(Main.WIDTH);
        backgroundView.setFitHeight(Main.HEIGHT);
        cur.getChildren().add(backgroundView);

        // add every interactive object onto the pane
        for(Interactive i : objects){
            cur.getChildren().add(i.getNode());
        }
    }

    @Override
    public Node getNode() {
        return cur;
    }
}
