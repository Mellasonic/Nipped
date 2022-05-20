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
 Time spent: 20 min
 New features/processing: allow setting locations & moving to them
*/

package mellasonic.nipped.game.point_and_click.locations;

// imports

import mellasonic.nipped.game.point_and_click.interactives.Food;

import java.util.ArrayList;
import java.util.Arrays;

import static mellasonic.nipped.Tools.getImage;

/**
 * The first room - a living room in level 1 and 3
 */
public abstract class LivingRoom extends Location {
    /**
     * Rooms in the various directions of the current location
     */
    private Location left, right, down;

    /**
     * Class constructor
     */
    public LivingRoom() {
        super(getImage("assets/livingroom.png"), new ArrayList<>());

        // add objects to the list of interactives
        addObjects(Arrays.asList(new Food(100, 100) {
            @Override
            public void onClick() {
                foodConsumed();
            }
        }, new Food(0, 300){
            @Override
            public void onClick() {
                assert left != null;
                screenChange(left);
            }
        }));
    }

    /**
     * Set the location to the left
     * @param left the location to the left
     */
    public void setLeft(Location left) {
        this.left = left;
    }

    /**
     * Set the location to the right
     * @param right the location to the right
     */
    public void setRight(Location right) {
        this.right = right;
    }

    /**
     * Set the location to the bottom
     * @param down the location to the bottom
     */
    public void setDown(Location down) {
        this.down = down;
    }

    /**
     * called when a piece of food is clicked
     */
    public abstract void foodConsumed();
}
