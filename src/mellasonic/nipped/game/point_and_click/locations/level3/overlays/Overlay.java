/* ICS Final Project Nipped
 2022/06/06
 Time spent: 40 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 7 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye, Eric Jin
 Version 1.1
 2022/06/06
 Time spent: 40 min
 New features/processing: create generic overlay
*/

package mellasonic.nipped.game.point_and_click.locations.level3.overlays;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import mellasonic.nipped.Main;
import mellasonic.nipped.game.point_and_click.Screen;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;

public abstract class Overlay implements Screen {
    /**
     * the previous location
     */
    private final Location prev;
    /**
     * the screen changer
     */
    private final ScreenChanger changer;
    /**
     * the current pane
     */
    private final Pane cur;

    /**
     * class constructor
     * @param prev the previous location
     * @param changer the screen changer
     */
    public Overlay(Location prev, ScreenChanger changer){
        this.prev = prev;
        this.changer = changer;
        cur = new Pane();
        cur.getChildren().add(prev.getNode());
        cur.setLayoutX(0);
        cur.setLayoutY(0);
        cur.setPrefSize(Main.WIDTH, Main.HEIGHT);

        // the background
        Rectangle bg = new Rectangle(0, 0, Main.WIDTH, Main.HEIGHT);
        bg.setFill(new Color(0, 0, 0, 0.4));
        cur.getChildren().add(bg);
    }

    /**
     * adds a node to the current pane
     * @param toAdd the node to add
     */
    protected void addNode(Node toAdd){
        cur.getChildren().add(toAdd);
    }

    /**
     * changes back to the previous screen; closes the overlay
     */
    protected void changeBack(){
        changer.screenChange(prev);
    }

    @Override
    public Node getNode() {
        return cur;
    }
}
