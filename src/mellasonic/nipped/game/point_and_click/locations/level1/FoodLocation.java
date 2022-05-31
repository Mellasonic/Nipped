package mellasonic.nipped.game.point_and_click.locations.level1;

import javafx.scene.image.Image;
import mellasonic.nipped.game.point_and_click.interactives.Food;
import mellasonic.nipped.interactable.Interactive;

import java.util.List;

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
