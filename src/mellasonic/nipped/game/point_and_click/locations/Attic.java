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
 * an attic
 */
public abstract class Attic extends Location implements FoodLocation{
    /**
     * the bedroom
     */
    private Location bedroom;

    /**
     * Class constructor
     *
     */
    public Attic() {
        super(Tools.getImage("assets/attic.png"), new ArrayList<>());
        addObjects(Arrays.asList(
                new Food(599, 392) {
                    @Override
                    public void onClick() {
                        onFoodClicked(this);
                    }
                },
                new Food(564, 153){
                    @Override
                    public void onClick() {
                        onFoodClicked(this);
                    }
                },
                new Button(Direction.D, Main.WIDTH / 2 - Button.WIDTH / 2, Main.HEIGHT - 20 - Button.HEIGHT) {
                    @Override
                    public void onClick() {
                        assert bedroom != null;
                        screenChange(bedroom);
                    }
                }
        ));
    }

    /**
     * sets the bedroom
     * @param bedroom the location of the bedroom
     */
    public void setBedroom(Location bedroom) {
        this.bedroom = bedroom;
    }
}
