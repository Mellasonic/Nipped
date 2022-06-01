/* ICS Final Project Nipped
 2022/05/18
 Time spent: 1 hour 20 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.2 - 17 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/17
 Time spent: 1 hour
 New features/processing: Created location, instance variables, drawing elements
*/

/*
 Modification Authors: Daniel Ye
 Version 1.2
 2022/05/18
 Time spent: 10 mins
 New features/processing: Allow adding multiple objects at once + re-rendering
*/

/*
 Modification Authors: Daniel Ye
 Version 1.3
 2022/05/20
 Time spent: 10 min
 New features/processing: Add request location change
*/

package mellasonic.nipped.game.point_and_click.locations;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import mellasonic.nipped.Main;
import mellasonic.nipped.game.point_and_click.Screen;
import mellasonic.nipped.interactable.Interactive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A Location in the point and click game
 */
public abstract class Location implements Screen {

    /**
     * A list of interactive objects
     */
    private final List<Interactive> objects;
    /**
     * The image to display in the background
     */
    private Image background;
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
     * sets the background
     * @param to the image to set the background to
     */
    public void setBackground(Image to){
        background = to;
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

    /**
     * Requests a change in screen
     * @param to the screen to change to
     */
    public abstract void screenChange(Screen to);
}