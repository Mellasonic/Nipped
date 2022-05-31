/* ICS Final Project Nipped
 2022/05/31
 Time spent: 20 min
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
 Time spent: 20 min
 New features/processing: Created Food Location interface, add default methods, remove redundant code from other locations
*/

package mellasonic.nipped.game.point_and_click.locations.level1;
import mellasonic.nipped.game.point_and_click.interactives.Food;

/**
 * An interface for all locations with the default functionality for food
 */
public interface FoodLocation{

    /**
     * Handles food clicking
     * @param clicked the food clicked
     */
    default void onFoodClicked(Food clicked){
        clicked.disable();
        foodConsumed();
    }

    /**
     * called when a piece of food is clicked
     */
    void foodConsumed();
}
