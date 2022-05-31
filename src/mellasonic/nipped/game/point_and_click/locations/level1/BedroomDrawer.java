package mellasonic.nipped.game.point_and_click.locations.level1;

import mellasonic.nipped.game.point_and_click.interactives.Food;

import java.util.Arrays;

/**
 * a drawer in the bedroom
 */
public abstract class BedroomDrawer extends Drawer implements FoodLocation {
    /**
     * class constructor
     */
    public BedroomDrawer(){
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
