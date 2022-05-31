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
