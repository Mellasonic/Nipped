/* ICS Final Project Nipped
 2022/05/18
 Time spent: 2 hour 30 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 18 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel
 Version 1.0
 2022/05/18
 Time spent: 1 hour
 New features/processing: Initial Class
*/

/*
 Modification Authors: Daniel
 Version 1.1
 2022/05/18
 Time spent: 2 hour
 New features/processing: Add Interactive elements
*/

/*
 Modification Authors: Daniel
 Version 1.2
 2022/05/19
 Time spent: 10 min
 New features/processing: Extrapolate food consume
*/

/*
 Modification Authors: Daniel
 Version 1.3
 2022/05/20
 Time spent: 30 min
 New features/processing: allow setting locations & moving to them, further extrapolate food clicking, add food
*/

package mellasonic.nipped.game.point_and_click.locations;

// imports

import mellasonic.nipped.Main;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.game.point_and_click.interactives.Food;

import java.util.ArrayList;
import java.util.Arrays;

import static mellasonic.nipped.Tools.getImage;

/**
 * The first room - a living room in level 1 and 3
 */
public abstract class LivingRoom extends Location {
    /**
     * The kitchen
     */
    private Location kitchen;
    /**
     * the bedroom
     */
    private Location bedroom;
    /**
     * the door
     */
    private Location door;

    /**
     * Class constructor
     */
    public LivingRoom() {
        super(getImage("assets/livingroom.png"), new ArrayList<>());

        // add objects to the list of interactives
        addObjects(Arrays.asList(new Button(Direction.L, 20, Main.HEIGHT / 2 - Button.HEIGHT / 2) {
            @Override
            public void onClick() {
                assert kitchen != null;
                screenChange(kitchen);
            }
        }, new Button(Direction.U, Main.WIDTH / 2 - Button.WIDTH / 2, 20) {
            @Override
            public void onClick() {
                assert bedroom != null;
                screenChange(bedroom);
            }
        }, new Button(Direction.R, Main.WIDTH - Button.WIDTH - 20, Main.HEIGHT / 2 - Button.HEIGHT) {
            @Override
            public void onClick() {
                assert door != null;
                screenChange(door);
            }
        }));
    }

    /**
     * set the location to the right
     * @param door the location to the right (the door)
     */
    public void setDoor(Location door) {
        this.door = door;
    }

    /**
     * Set the location to the left
     * @param kitchen the location to the left
     */
    public void setKitchen(Location kitchen) {
        this.kitchen = kitchen;
    }

    /**
     * Set the location to the right
     * @param bedroom the location to the right
     */
    public void setBedroom(Location bedroom) {
        this.bedroom = bedroom;
    }
}
