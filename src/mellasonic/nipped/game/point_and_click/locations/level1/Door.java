/* ICS Final Project Nipped
 2022/05/31
 Time spent: 30 min
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
 Time spent: 30 min
 New features/processing: created door, add opening & next-level functions, add ghost collider
*/

package mellasonic.nipped.game.point_and_click.locations.level1;

import javafx.scene.image.Image;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.interactable.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The door
 */
public abstract class Door extends Location {
    /**
     * whether or not the door has already been opened
     */
    private boolean doorOpened = false;
    /**
     * the living room
     */
    private Location living;

    /**
     * Class constructor
     */
    public Door() {
        super(Tools.getImage("assets/doorclose.png"), new ArrayList<>());
        // a ghost collider for detecting the door
        Image ghostCollide = Tools.getImage("assets/invisible.png");
        addObjects(Arrays.asList(
                new Rectangle(ghostCollide, ghostCollide, 368, 144, 138, 251) {
                    @Override
                    public void onClick() {
                        if(doorOpened) {
                            // if the door was opened and is clicked again, continue
                            onDoorClicked();
                        } else {
                            // do nothing
                            System.out.println("not done yet");
                        }
                    }
                }, new Button(Direction.L, 20, Main.HEIGHT / 2 - Button.HEIGHT / 2) {
                    @Override
                    public void onClick() {
                        assert living != null;
                        screenChange(living);
                    }
                }
        ));
    }

    /**
     * sets the living room
     * @param living the living room
     */
    public void setLiving(Location living) {
        this.living = living;
    }

    /**
     * called when the door is clicked **and** the game is supposedly done
     */
    public abstract void onDoorClicked();

    /**
     * enables the door - should be called when all other activities have been completed
     */
    public void enable(){
        doorOpened = true;
        setBackground(Tools.getImage("assets/dooropen.png"));
    }
}
