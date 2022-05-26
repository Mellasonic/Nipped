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

package mellasonic.nipped.game.point_and_click.locations;

import javafx.scene.image.Image;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.game.point_and_click.interactives.Food;
import mellasonic.nipped.interactable.Interactive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Kitchen room
 */
public abstract class Kitchen extends Location{

    /**
     * The living room
     */
    private Location living;

    /**
     * Class constructor
     *
     */
    public Kitchen() {
        super(Tools.getImage("assets/kitchen.png"), new ArrayList<>());
        addObjects(Arrays.asList(
                new Button(Direction.R, Main.WIDTH - Button.WIDTH - 20, Main.HEIGHT / 2 - Button.HEIGHT / 2) {
                    @Override
                    public void onClick() {
                        assert living != null;
                        screenChange(living);
                    }
                },
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

    /**
     * set the living room
     * @param living the room to set the living room to
     */
    public void setLiving(Location living) {
        this.living = living;
    }

    /**
     * Handles food clicking
     * @param clicked the food clicked
     */
    private void onFoodClicked(Food clicked){
        foodConsumed();
    }

    /**
     * called when a piece of food is clicked
     */
    public abstract void foodConsumed();
}
