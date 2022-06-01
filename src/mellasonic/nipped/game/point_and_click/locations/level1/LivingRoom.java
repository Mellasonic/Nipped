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

package mellasonic.nipped.game.point_and_click.locations.level1;

// imports

import mellasonic.nipped.game.point_and_click.interactives.Food;
import mellasonic.nipped.game.point_and_click.locations.Location;

import java.util.Arrays;

/**
 * The first room - a living room in level 1 and 3
 */
public abstract class LivingRoom extends mellasonic.nipped.game.point_and_click.locations.LivingRoom implements FoodLocation {

    /**
     * Class constructor
     */
    public LivingRoom() {
        // add objects to the list of interactives
        addObjects(Arrays.asList(
                new Food(600, 75) {
                    @Override
                    public void onClick() {
                        onFoodClicked(this);
                    }
                }, new Food(650, 235) {
                    @Override
                    public void onClick() {
                        onFoodClicked(this);
                    }
                }, new Food(300, 290) {
                    @Override
                    public void onClick() {
                        onFoodClicked(this);
                    }
                }
        ));
    }
}
