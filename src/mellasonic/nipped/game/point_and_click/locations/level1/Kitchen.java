/* ICS Final Project Nipped
 2022/05/26
 Time spent: 30 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 26 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.1
 2022/05/26
 Time spent: 30 min
 New features/processing: create kitchen, add food
*/

package mellasonic.nipped.game.point_and_click.locations.level1;

import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.game.point_and_click.interactives.Food;
import mellasonic.nipped.game.point_and_click.interactives.Invisible;
import mellasonic.nipped.game.point_and_click.locations.Location;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Kitchen room
 */
public abstract class Kitchen extends mellasonic.nipped.game.point_and_click.locations.Kitchen implements FoodLocation{

    /**
     * Class constructor
     *
     */
    public Kitchen() {
        addObjects(Arrays.asList(
                new Food(200, 235) {
                    @Override
                    public void onClick() {
                        onFoodClicked(this);
                    }
                },
                new Food(700, 235){
                    @Override
                    public void onClick() {
                        onFoodClicked(this);
                    }
                }
        ));
    }
}
