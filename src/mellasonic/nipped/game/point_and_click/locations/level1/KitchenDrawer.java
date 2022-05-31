/* ICS Final Project Nipped
 2022/05/31
 Time spent: 10 min
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
 Time spent: 10 min
 New features/processing: Create Kitchen Drawer, add & position Food
*/

package mellasonic.nipped.game.point_and_click.locations.level1;

import mellasonic.nipped.game.point_and_click.interactives.Food;

import java.util.Arrays;

public abstract class KitchenDrawer extends Drawer implements FoodLocation{
    /**
     * Class Constructor
     */
    public KitchenDrawer(){
        super();
        addObjects(Arrays.asList(
                new Food(502, 250){
                    @Override
                    public void onClick() {
                        onFoodClicked(this);
                    }
                }
        ));
    }
}
