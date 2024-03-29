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
 Modification Authors: Daniel Ye, James Huynh
 Version 1.1
 2022/05/31
 Time spent: 30 min
 New features/processing: created door, add opening & next-level functions, add ghost collider
*/

package mellasonic.nipped.game.point_and_click.locations.level1;

import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.game.point_and_click.interactives.Invisible;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;

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
     * whether or not the sprites are greyscaled
     */
    private final boolean isGrey;
    /**
     * the invisible collider for the door
     */
    private final Invisible collider;

    /**
     * Class constructor
     *
     * @param changer the screen change handler
     * @param grey whether or not the room is greyscale
     */
    public Door(ScreenChanger changer, boolean grey) {
        super(grey ? Tools.getImage("assets/doorclosegs.png") : Tools.getImage("assets/doorclose.png"), changer);
        this.isGrey = grey;

        // a ghost collider for detecting the door
        collider = new Invisible(368, 144, 138, 251, false) {
            @Override
            public void onClick() {
                if(doorOpened) {
                    // if the door was opened and is clicked again, continue
                    onDoorClicked();
                }
            }
        };

        addObjects(Arrays.asList(
                collider,
                new Button(Direction.L, 20, Main.HEIGHT / 2 - Button.HEIGHT / 2) {
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
        collider.setHasStar(true);
        setBackground(isGrey ? Tools.getImage("assets/dooropengs.png") : Tools.getImage("assets/dooropen.png"));
    }
}
